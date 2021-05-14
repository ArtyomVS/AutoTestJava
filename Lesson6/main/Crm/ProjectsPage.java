package lesson6.Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BaseView {
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Создать проект']")
    public WebElement createProject;
}
