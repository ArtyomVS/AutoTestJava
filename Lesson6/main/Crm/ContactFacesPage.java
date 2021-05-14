package lesson6.Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactFacesPage extends BaseView {
    public ContactFacesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Создать контактное лицо']")
    public WebElement createNewContactFace;
}
