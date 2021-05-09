package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDiary {
    WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";

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

    @Test(description = "Новый проект", enabled = true)
    void createNewEntry() throws InterruptedException {
        //Без кук пишет: нет прав, так что приходится подключать куки вновь
        driver.findElement(By.xpath("//a[@href = 'https://testosterovshik.diary.ru/?newpost']")).click();
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "138rhld1t1r5q9ttr1idv0grno");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        //Заголовок
        driver.findElement(By.xpath("//input[@id = 'postTitle']")).sendKeys("Будни тестера. Часть 5");
        //Сообщение
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка это просто, иди в тестировщики, там реальные задачи");
        driver.switchTo().defaultContent();
        //Настроение
        driver.findElement(By.xpath("//input[@id = 'atMoodBoxCheck']")).click();
        driver.findElement(By.xpath("//input[@id = 'atMood']")).sendKeys("Зашибенное");
        //Публикация
        driver.findElement(By.xpath("//input[@id = 'rewrite']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://testosterovshik.diary.ru/", "(При создании записи возникла ошибка, запись не был создана). ");
        Thread.sleep(5000);
    }

    void login() {
        driver.get(LOGIN_PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "138rhld1t1r5q9ttr1idv0grno");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

    }
    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}
