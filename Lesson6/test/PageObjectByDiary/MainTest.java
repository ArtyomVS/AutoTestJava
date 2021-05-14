package lesson6.PageObjectByDiary;

import lesson6.Diary.LoginPage;
import lesson6.Diary.NavigationMenu;
import lesson6.Diary.NewPostPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static lesson6.Diary.Config.BASE_URL;

public class MainTest extends BaseTest {
    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        navigationMenu = new NavigationMenu(driver);
        newPostPage = new NewPostPage(driver);
        login();
    }

    void login() {
        loginPage.loginWithCookie();
    }

    @Test
    void createNewEntry() throws InterruptedException{
        navigationMenu.linkToNewPostPage.click();
        login();
        newPostPage.title.sendKeys("Будни тестера. Часть 9");
        newPostPage.frame();
        newPostPage.mood("Зашибенное");
        newPostPage.rewrite.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testosterovshik.diary.ru/");
        Thread.sleep(5000);
    }

}
