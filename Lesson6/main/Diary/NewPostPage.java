package lesson6.Diary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPostPage extends BaseView{
    public NewPostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "postTitle")
    public WebElement title;

    public void frame(){
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка это просто, иди в тестировщики, там реальные задачи");
        driver.switchTo().defaultContent();
    }

    @FindBy(id = "atMoodBoxCheck")
    public WebElement moodBoxCheck;

    @FindBy(id = "atMood")
    public WebElement atMood;

    public void mood(String sentiment){
        moodBoxCheck.click();
        atMood.sendKeys(sentiment);
    }

    @FindBy(id = "rewrite")
    public WebElement rewrite;
}
