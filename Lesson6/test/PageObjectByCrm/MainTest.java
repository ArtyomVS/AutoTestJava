package lesson6.PageObjectByCrm;

import lesson6.Crm.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static lesson6.Crm.Config.BASE_URL;

public class MainTest extends iFrameTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        navigationMenu = new NavigationMenu(driver);
        contactFacesPage = new ContactFacesPage(driver);
        createNewContactFacePage = new CreateNewContactFacePage(driver);
        projectsPage = new ProjectsPage(driver);
        createNewProjectPage = new CreateNewProjectPage(driver);
        login();
    }

    void login() {
        loginPage.login.sendKeys("Applanatest1");
        loginPage.password.sendKeys("Student2020!");
        loginPage.btnSubmit.click();
    }

    @Test
    void newContactFace() throws InterruptedException {
        navigationMenu.openNavigationMenuForContacts();
        Thread.sleep(3000);
        contactFacesPage.createNewContactFace.click();
        Thread.sleep(3000);
        createNewContactFacePage.lastName.sendKeys("ШальнойБоярин");
        createNewContactFacePage.firstName.sendKeys("Шишибалаша");
        createNewContactFacePage.organization();
        createNewContactFacePage.jobTitle.sendKeys("TOP Super Mega Ecstra QA Engineer");
        createNewContactFacePage.saveAndClose.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.geekbrains.space/contact/");
    }

    @Test
    void newProject() throws InterruptedException {
        navigationMenu.openNavigationMenuForProject();
        Thread.sleep(3000);
        projectsPage.createProject.click();
        Thread.sleep(3000);
        createNewProjectPage.nameProject.sendKeys("Очередной амбициозный проектe");
        createNewProjectPage.organization();
        createNewProjectPage.typeProject.click();
        createNewProjectPage.selectPriority("Высокий");
        createNewProjectPage.selectFinance("Инвестиции");
        createNewProjectPage.selectBusinessUnit("Research & Development");
        createNewProjectPage.selectCurator("Applanatest2 Applanatest2 Applanatest2");
        createNewProjectPage.selectRp("Applanatest1 Applanatest1 Applanatest1");
        createNewProjectPage.selectAdmin("Applanatest Applanatest Applanatest");
        createNewProjectPage.selectManager("Студентов Студент");
        createNewProjectPage.contactFace();
        writeFrame();
        createNewProjectPage.configManagement.sendKeys("Управление конфигурацией системы лежит на президенте");
        createNewProjectPage.skipSpeedChecks.click();
        createNewProjectPage.selectReportInterval("Ежеквартально");
        createNewProjectPage.saveAndClose.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.geekbrains.space/project/");
        Thread.sleep(5000);
    }
}
