package lesson6.Diary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseView {
    WebDriver driver;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
