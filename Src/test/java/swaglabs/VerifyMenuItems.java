package swaglabs;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class VerifyMenuItems extends base{
    @Test
    public void VerifyMenuItems() throws IOException, InterruptedException {
        driver =initializeDriver();
        LoginPage lp = new LoginPage(driver);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        navigateToURL(prop.getProperty("url"));

        //loging in as a valid user
        lp.Login(prop.getProperty("username"),prop.getProperty("password"));
        HomePage hp = new HomePage(driver);
        ArrayList<String> expectedList= new ArrayList<String>();
        expectedList.add("ALL ITEMS");
        expectedList.add("ABOUT");
        expectedList.add("LOGOUT");
        expectedList.add("RESET APP STATE");
        hp.hamBurgerIcon.click();
        wait(1);
        ArrayList<String> al = new ArrayList<String>();
        for(int i=0;i<hp.itemsList.size();i++){
            String s= hp.itemsList.get(i).getText();
            log(s);
            al.add(s);
        }

        Assert.assertEquals(al,expectedList);

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
