package lesson6.Diary;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseView{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithCookie(){
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "sde5bfmpnruvl5pi584tjiddl6");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
