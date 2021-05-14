package lesson6.TorrentIgruha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginView extends BaseView {
    @FindBy(id = "open-mini-profile")
    public WebElement windowAutorization;
    @FindBy(xpath = "//input[@id = \"login_name\"]")
    public WebElement inputLogin;
    @FindBy(xpath = "//input[@id = \"login_password\"]")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[@class = \"fbutton\"]")
    public WebElement submitLogin;

    public LoginView(WebDriver driver) {
        super(driver);
    }


    /* (На будущее)
    public LoginView fillInputWindowAutorization(String windowAutoriz){
        windowAutorization.click();
        return this;
    }
    public LoginView fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }
    public LoginView fillInputPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public LoginView buttonSubmitLogin(String btnLogin){
        submitLogin.click();
        return this;
    }
    */
}
