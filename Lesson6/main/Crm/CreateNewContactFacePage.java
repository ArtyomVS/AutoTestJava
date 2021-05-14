package lesson6.Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContactFacePage extends BaseView {
    public CreateNewContactFacePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    @FindBy(xpath = "//span[text() = 'Укажите организацию']")
    public WebElement indicateOrganization;

    @FindBy(xpath = "//div[text() = '123test']")
    public WebElement pickOrganization;

    public void organization() throws InterruptedException {
        indicateOrganization.click();
        Thread.sleep(3000);
        pickOrganization.click();
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement saveAndClose;

}
