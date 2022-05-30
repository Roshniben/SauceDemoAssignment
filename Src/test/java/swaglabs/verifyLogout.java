package swaglabs;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class verifyLogout extends base{

    @Test
    public void verifyLogout() throws IOException, InterruptedException {
        driver = initializeDriver();
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));
        lp.Login(prop.getProperty("username"), prop.getProperty("password"));
        wait(1);
        hp.hamBurgerIcon.click();
        hp.btnLogout.click();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
