package lesson6.TorrentIgruha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {
    @FindBy(xpath = "//a[@title = \"Need for Speed Most Wanted 2005\"]")
    public WebElement gamePage;
    @FindBy(id = "sunimgid")
    public WebElement colorPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
