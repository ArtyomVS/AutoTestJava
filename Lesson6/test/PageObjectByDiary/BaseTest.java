package lesson6.PageObjectByDiary;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.Diary.LoginPage;
import lesson6.Diary.NavigationMenu;
import lesson6.Diary.NewPostPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    NavigationMenu navigationMenu;
    NewPostPage newPostPage;
    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
