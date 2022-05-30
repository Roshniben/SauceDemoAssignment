package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath=".//*[contains(text(),'Add to cart')]")
    public List<WebElement> btnItemsToCart;

    @FindBy(id ="shopping_cart_container")
    public WebElement lnkShoppingCart;

    @FindBy(id="checkout")
    public WebElement btnCheckOut;

    @FindBy(id="first-name")
    public WebElement txtFname;

    @FindBy(id="last-name")
    public WebElement txtLname;

    @FindBy(id="postal-code")
    public WebElement txtZipCode;

    @FindBy(id="continue")
    public WebElement btnContinue;

    @FindBy(id="finish")
    public WebElement btnFinish;

    @FindBy(xpath=".//*[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    public WebElement txtThankYou;

    @FindBy(id="back-to-products")
    public WebElement btnBack;

    @FindBy(xpath = ".//*[@class='title']")
    public WebElement txtTitle;

    @FindBy(xpath = ".//*[@class='product_sort_container']")
    public WebElement dropDownList;

    @FindBy(xpath = ".//*[@class='footer_copy']")
    public WebElement txtFooter;
}
