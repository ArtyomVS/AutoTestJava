package lesson6.Diary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BaseView{
    public NavigationMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href = 'https://testosterovshik.diary.ru/?newpost']")
    public WebElement linkToNewPostPage;
}
