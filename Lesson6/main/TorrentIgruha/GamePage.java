package lesson6.TorrentIgruha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BaseView {
    @FindBy(xpath = "//a[@title = \"Нравится\"]")
    public WebElement likeGame;

    public GamePage(WebDriver driver) {
        super(driver);
    }
}
