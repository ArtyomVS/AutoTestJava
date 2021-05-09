package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestTorrentIgruha {
    WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://s2.torrents-igruha.org/";

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    void setUpBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        login();
    }

    @Test(description = "Проверка включения ночного режима", enabled = true, priority = 0)
    void nightMode() throws InterruptedException {
        driver.findElement(By.id("sunimgid")).click();
        Thread.sleep(3000);
        String themeDark = driver.findElement(By.id("sunimgid")).getCssValue("color");//Берём цвет элемента
        Assert.assertEquals("rgba(189, 189, 189, 1)", themeDark);//Сравниваем цвет с характерным для ночного режима
        Thread.sleep(3000);
    }

    @Test(description = "Проверка корректности счётчика лайков", enabled = true, priority = 1)
    void likeСounter() throws InterruptedException {
        driver.findElement(By.xpath("//a[@title = \"Euro Truck Simulator 2\"]")).click();//В этой строке нужно каждый раз подставлять название новой игры (ассортимент на сайте регулярно обновляется)
        Integer likeValueBefore = Integer.valueOf(driver.findElement(By.xpath("//a[@class = 'orating_res']")).getText());
        System.out.println("Изначальное количество лайков " + likeValueBefore);
        likeValueBefore++;
        driver.findElement(By.xpath("//a[@title = \"Нравится\"]")).click();
        Thread.sleep(3000);
        Integer likeValueAfter = Integer.valueOf(driver.findElement(By.xpath("//a[@class = 'orating_res']")).getText());
        System.out.println("Изменение количества лайков " + likeValueAfter);
        Assert.assertEquals(likeValueBefore, likeValueAfter, "Ошибка! Лайк не поставлен. Подробная информация: ");
        Thread.sleep(3000);
    }

    void login() throws InterruptedException {
        driver.findElement(By.id("open-mini-profile")).click();
        driver.findElement(By.xpath("//input[@id = \"login_name\"]")).sendKeys("Testosterovshik");
        driver.findElement(By.xpath("//input[@id = \"login_password\"]")).sendKeys("Qvaqvayatester");
        driver.findElement(By.xpath("//button[@class = \"fbutton\"]")).click();
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }


}
