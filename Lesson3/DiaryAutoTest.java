package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DiaryAutoTest {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login();
        createNewEntry();
        Thread.sleep(5000);
        driver.close();
    }

    private static void createNewEntry() throws InterruptedException {
        //Без кук пишет: нет прав, так что приходится подключать куки вновь
        driver.findElement(By.xpath("//a[@href = 'https://testosterovshik.diary.ru/?newpost']")).click();
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "olvvrc6gabj7qbfufmcghof90l");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        //Заголовок
        driver.findElement(By.xpath("//input[@id = 'postTitle']")).sendKeys("Будни тестера. Часть 4");
        //Сообщение
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка это просто, иди в тестировщики, там реальные задачи");
        driver.switchTo().defaultContent();
        //Настроение
        driver.findElement(By.xpath("//input[@id = 'atMoodBoxCheck']")).click();
        driver.findElement(By.xpath("//input[@id = 'atMood']")).sendKeys("Зашибенное");
        //Публикация
        driver.findElement(By.xpath("//input[@id = 'rewrite']")).click();
    }

    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "olvvrc6gabj7qbfufmcghof90l");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
