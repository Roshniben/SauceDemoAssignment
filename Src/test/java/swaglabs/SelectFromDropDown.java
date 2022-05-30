package swaglabs;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SelectFromDropDown extends base{

    @Test
    public void verifyDropDowns() throws IOException, InterruptedException {
        driver = initializeDriver();
        CartPage cpage = new CartPage(driver);
        LoginPage lp = new LoginPage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));
        lp.Login(prop.getProperty("username"), prop.getProperty("password"));
        wait(1);
        cpage.dropDownList.click();
        select(cpage.dropDownList,"lohi");
        wait(1);
        cpage.btnItemsToCart.get(1).click();


    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
