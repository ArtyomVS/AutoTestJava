package lesson6.Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement login;
    @FindBy(id = "prependedInput2")
    public WebElement password;
    @FindBy(id = "_submit")
    public WebElement btnSubmit;

}
