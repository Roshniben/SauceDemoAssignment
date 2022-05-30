package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="react-burger-menu-btn")
    public WebElement hamBurgerIcon;

    @FindBy(xpath=".//*[@class='bm-item-list']//a")
    public List<WebElement> itemsList;

    @FindBy(id="logout_sidebar_link")
    public WebElement btnLogout;


}
