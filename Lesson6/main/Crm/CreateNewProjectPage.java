package lesson6.Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjectPage extends BaseView {
    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement nameProject;
    @FindBy(xpath = "//span[text() = 'Укажите организацию']")
    public WebElement indicateOrganization;

    @FindBy(xpath = "//div[text() = '123test']")
    public WebElement pickOrganization;

    public void organization() throws InterruptedException {
        indicateOrganization.click();
        Thread.sleep(3000);
        pickOrganization.click();
    }

    @FindBy(name = "crm_project[type]")
    public WebElement typeProject;

    @FindBy(name = "crm_project[priority]")
    public WebElement priorityProject;

    public CreateNewProjectPage selectPriority(String priorityName) {
        new Select(priorityProject).selectByVisibleText(priorityName);
        return this;
    }

    @FindBy(name = "crm_project[financeSource]")
    public WebElement financeProject;

    public CreateNewProjectPage selectFinance(String financeName) {
        new Select(financeProject).selectByVisibleText(financeName);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessProject;

    public CreateNewProjectPage selectBusinessUnit(String businessUnitName) {
        new Select(businessProject).selectByVisibleText(businessUnitName);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorProject;

    public CreateNewProjectPage selectCurator(String CuratorName) {
        new Select(curatorProject).selectByVisibleText(CuratorName);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpProject;

    public CreateNewProjectPage selectRp(String rpName) {
        new Select(rpProject).selectByVisibleText(rpName);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement adminProject;

    public CreateNewProjectPage selectAdmin(String adminName) {
        new Select(adminProject).selectByVisibleText(adminName);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerProject;

    public CreateNewProjectPage selectManager(String managerName) {
        new Select(managerProject).selectByVisibleText(managerName);
        return this;
    }

    @FindBy(xpath = "//div[contains(@id,'s2id_crm_project_contactMain')]/a")
    public WebElement contactFaces;

    @FindBy(xpath = "//select[@name=\"crm_project[contactMain]\"]/option[3]")
    public WebElement selectContactFace;

    public void contactFace() throws InterruptedException {
        contactFaces.click();
        Thread.sleep(3000);
        selectContactFace.click();
    }

    public void iFrame(String xpath) {
        if (xpath == "//iframe[contains(@id, 'planning')]") {
            driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
            driver.findElement(By.xpath("//body")).sendKeys("Планирование очень важно для каждой организации, иногда мы будем даже пытаться это делать");
            driver.switchTo().defaultContent();
        } else if (xpath == "//iframe[contains(@id, 'requirementsManagement')]") {
            driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
            driver.findElement(By.xpath("//body")).sendKeys("Требования управляют требованиями - начинающий философ, джуниор кью эй инженер");
            driver.switchTo().defaultContent();
        } else if (xpath == "//iframe[contains(@id, 'development')]") {
            driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
            driver.findElement(By.xpath("//body")).sendKeys("Разработка это просто, иди в тестировщики, там реальные задачи");
            driver.switchTo().defaultContent();
        } else if (xpath == "//iframe[contains(@id, 'testing')]") {
            driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
            driver.findElement(By.xpath("//body")).sendKeys("Тестирование - это просто, иди в разработку - там серьёзные задачи");
            driver.switchTo().defaultContent();
        }
    }

    @FindBy(name = "crm_project[configManagement]")
    public WebElement configManagement;

    @FindBy(name = "crm_project[skipSpeedChecks]")
    public WebElement skipSpeedChecks;

    @FindBy(name = "crm_project[reportInterval]")
    public WebElement reportInterval;

    public CreateNewProjectPage selectReportInterval(String intervalName) {
        new Select(reportInterval).selectByVisibleText(intervalName);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement saveAndClose;

}
