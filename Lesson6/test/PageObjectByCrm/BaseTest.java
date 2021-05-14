package lesson6.PageObjectByCrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.Crm.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    NavigationMenu navigationMenu;
    ContactFacesPage contactFacesPage;
    CreateNewContactFacePage createNewContactFacePage;
    ProjectsPage projectsPage;
    CreateNewProjectPage createNewProjectPage;
    WebDriver driver;

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
