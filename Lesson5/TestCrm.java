package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestCrm {
    WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    void setUpBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        login();
    }

    @Test(description = "Новый проект", enabled = true)
    void newProject() throws InterruptedException {
        //Переходим на страницу создания нового проекта
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();
        driver.findElement(By.xpath("//span[text() = 'Мои проекты']/ancestor::a")).click();
        driver.findElement(By.xpath("//a[text() = 'Создать проект']")).click();
        //Заполняем название
        driver.findElement(By.xpath("//input[@name = 'crm_project[name]']")).click();
        driver.findElement(By.xpath("//input[@name = 'crm_project[name]']")).sendKeys("Новый супер амбицознbый праыд1");
        //Название организации
        driver.findElement(By.xpath("//span[text() = 'Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[text() = '123test']")).click();
        //Тип
        driver.findElement(By.xpath("//input[@name = 'crm_project[type]']")).click();
        //Приоритет
        Select priorityProject = new Select(driver.findElement(By.name("crm_project[priority]")));
        priorityProject.selectByVisibleText("Высокий");
        //Финансирование
        Select financeProject = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        financeProject.selectByVisibleText("Инвестиции");
        //Подразделение
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");
        //Куратор проекта
        Select curatorOfTheProject = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorOfTheProject.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");
        //Руководитель проекта
        Select leaderManager = new Select(driver.findElement(By.name("crm_project[rp]")));
        leaderManager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        //Администратор проекта
        Select adminProject = new Select(driver.findElement(By.name("crm_project[administrator]")));
        adminProject.selectByVisibleText("Applanatest Applanatest Applanatest");
        //Менеджер
        Select managerProject = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerProject.selectByVisibleText("Студентов Студент");
        //Контактные лица
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[3]")).click();
        //Iframe 1: Планирование
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Планирование очень важно для каждой организации, иногда мы будем даже пытаться это делать");
        driver.switchTo().defaultContent();
        //Iframe 2: Управление требованиями
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Требования управляют требованиями - начинающий философ, джуниор кью эй инженер");
        driver.switchTo().defaultContent();
        //Iframe 3: Разработка
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'development')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка это просто, иди в тестировщики, там реальные задачи");
        driver.switchTo().defaultContent();
        //Iframe 4: Тестирование
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование - это просто, иди в разработку - там серьёзные задачи");
        driver.switchTo().defaultContent();
        //Управление конфигурацией
        driver.findElement(By.name("crm_project[configManagement]")).sendKeys("Управление конфигурацией системы лежит на президенте");
        //Всегда открывать проект в развернутом виде
        driver.findElement(By.name("crm_project[skipSpeedChecks]")).click();
        //Переодичность генерации отчётов
        Select generatingReports = new Select(driver.findElement(By.name("crm_project[reportInterval]")));
        generatingReports.selectByVisibleText("Ежеквартально");
        //Сохранение проекта
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://crm.geekbrains.space/project/", "(При создании проекта возникла ошибка, проект не был создан). ");
        Thread.sleep(5000);
    }

    @Test(description = "Новый контакт", enabled = true)
    void newContactFace() throws InterruptedException {
        //Переходим на страницу создания нового контакта
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();
        driver.findElement(By.xpath("//span[text() = 'Контактные лица']/ancestor::a")).click();
        driver.findElement(By.xpath("//a[text() = 'Создать контактное лицо']")).click();
        //Фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("ШальнойиЙ131233");
        //Имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Шишибараша231332");
        //Организация
        driver.findElement(By.xpath("//span[text() = 'Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[text() = '123test']")).click();
        //Должность
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("TOP Super Mega Ecstra QA Engineer");
        //Сохранение контакта
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://crm.geekbrains.space/contact/", "(При создании контакта возникла ошибка, контактное лицо не было создано). ");
        Thread.sleep(5000);
    }

    void login() throws InterruptedException {
        Assert.assertEquals("Логин", driver.getTitle(), " (Возможная причина ошибки: Неверный URL страницы). ");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }


}
