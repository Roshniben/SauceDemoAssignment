package swaglabs;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AddItemToCart extends base{
    @Test
    public void verifyAddItems() throws IOException, InterruptedException, AWTException {
        driver = initializeDriver();
        CartPage cpage = new CartPage(driver);
        LoginPage lp = new LoginPage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));
        lp.Login(prop.getProperty("username"), prop.getProperty("password"));

        //select and items to cart
        cpage.btnItemsToCart.get(0).click();
        wait(1);
        cpage.lnkShoppingCart.click();

        log("checking out to cart");
        cpage.btnCheckOut.click();
        wait(1);
        cpage.txtFname.click();
        cpage.txtFname.sendKeys("Roshni");
        cpage.txtLname.click();
        cpage.txtLname.sendKeys("Patel");
        cpage.txtZipCode.click();
        cpage.txtZipCode.sendKeys("L3Z 2E6");
        cpage.btnContinue.click();
        wait(1);
        String title = cpage.txtTitle.getText();
        log("Title of the page is:"+title);
        cpage.btnFinish.click();

        log("verifying thank you page");
        VerifyElementPresent(By.xpath(".//*[contains(text(),'THANK YOU FOR YOUR ORDER')]"),15);
        cpage.btnBack.click();

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
