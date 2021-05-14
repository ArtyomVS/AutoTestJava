package lesson6.Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BaseView {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контрагенты']/ancestor::a")
    public WebElement contragents;

    @FindBy(xpath = "//span[text() = 'Контактные лица']/ancestor::a")
    public WebElement contactFaces;

    public void openNavigationMenuForContacts() {
        Actions actions = new Actions(driver);
        WebElement contactMenuItem = contragents;
        actions.moveToElement(contactMenuItem).perform();
        contactFaces.click();
    }

    @FindBy(xpath = "//span[text()='Проекты']/ancestor::a")
    public WebElement navMenuProjects;

    @FindBy(xpath = "//span[text() = 'Мои проекты']/ancestor::a")
    public WebElement navMenuActionsMyProject;

    public void openNavigationMenuForProject() {
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = navMenuProjects;
        actions.moveToElement(projectMenuItem).perform();
        navMenuActionsMyProject.click();
    }
}
