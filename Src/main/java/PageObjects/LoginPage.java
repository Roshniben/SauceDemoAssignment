package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
   public WebDriver driver;
    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    public WebElement userName;

    @FindBy(id ="password" )
    public WebElement passWord;

    @FindBy(id = "login-button")
    public WebElement btnLogin;

    public void Login(String username, String password){
        userName.click();
        userName.sendKeys(username);
        passWord.click();
        passWord.sendKeys(password);
        btnLogin.click();

    }
}
