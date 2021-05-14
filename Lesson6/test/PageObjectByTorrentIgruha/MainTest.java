package lesson6.PageObjectByTorrentIgruha;

import lesson6.TorrentIgruha.GamePage;
import lesson6.TorrentIgruha.LoginView;
import lesson6.TorrentIgruha.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import static lesson6.TorrentIgruha.Conf.BASE_URL;

public class MainTest extends BaseTest {

    @BeforeEach
    public void goToPage() throws InterruptedException {
        driver.get(BASE_URL);
        loginView = new LoginView(driver);
        mainPage = new MainPage(driver);
        gamePage = new GamePage(driver);
        loginTest();
    }

    void loginTest() throws InterruptedException {
        loginView.windowAutorization.click();
        loginView.inputLogin.sendKeys("Testosterovshik");
        loginView.inputPassword.sendKeys("Qvaqvayatester");
        loginView.submitLogin.click();
    }

    @Test
    void lightPage() {
        mainPage.colorPage.click();
        Assert.assertEquals("rgba(189, 189, 189, 1)", mainPage.colorPage.getCssValue("color"));
    }

    @Test
    void likeСounter() throws InterruptedException {
        mainPage.gamePage.click();
        likeValueBef();
        gamePage.likeGame.click();
        Thread.sleep(1000);
        likeValueAft();
        Assert.assertEquals(likeValueBefore, likeValueAfter);
    }

    void likeValueBef() {
        likeValueBefore = Integer.valueOf(driver.findElement(By.xpath("//a[@class = 'orating_res']")).getText()) + 1;
    }

    void likeValueAft() {
        likeValueAfter = Integer.valueOf(driver.findElement(By.xpath("//a[@class = 'orating_res']")).getText());
    }

}
