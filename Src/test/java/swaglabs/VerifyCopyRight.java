package swaglabs;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VerifyCopyRight extends base{
    @Test
    public void copyRight() throws IOException, InterruptedException {
        driver = initializeDriver();
        CartPage cpage = new CartPage(driver);
        LoginPage lp = new LoginPage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));
        lp.Login(prop.getProperty("username"), prop.getProperty("password"));
        wait(1);
        scrollBottom();
        String copyRightInfo=cpage.txtFooter.getText();
        log("copy right information is:"+ copyRightInfo);

    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
