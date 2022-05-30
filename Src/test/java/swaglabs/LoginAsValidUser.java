package swaglabs;
import PageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginAsValidUser extends  base{
    @Test
    public void LoginToSite() throws IOException {
     driver =initializeDriver();
        LoginPage lp = new LoginPage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));

        //loging in as a valid user
        lp.Login(prop.getProperty("username"),prop.getProperty("password"));

    }


    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
