package lesson6.PageObjectByTorrentIgruha;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.TorrentIgruha.GamePage;
import lesson6.TorrentIgruha.LoginView;
import lesson6.TorrentIgruha.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    LoginView loginView;
    MainPage mainPage;
    GamePage gamePage;
    Integer likeValueBefore;
    Integer likeValueAfter;

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
