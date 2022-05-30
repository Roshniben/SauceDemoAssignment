package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/swaglabs/details.properties");
        prop.load(fis);
        String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void wait(int numOfSeconds) throws InterruptedException {
        log("Waiting for " + numOfSeconds + " seconds...");
        Thread.sleep((long) (numOfSeconds * 1000));
    }


    public  void Wait(WebElement element, int timeoutInSeconds) throws HeadlessException, IOException, AWTException {
        log("Waiting for " + element + " for up to " + timeoutInSeconds + " seconds.");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            log("Element found.");
        } catch (Exception var3) {
            log("*** Unable to find element");
            log(var3.getMessage());
            log("***");
            Assert.assertTrue(false);
        }

    }


    public  boolean VerifyElementPresent(final By elementLocator, int timeout) throws HeadlessException, IOException, AWTException {
        log("Wait for Element : " + elementLocator + " to be present on UI for maximum [" + timeout + "] seconds");

        try {
            (new WebDriverWait(driver, Duration.ofSeconds((long)timeout)) {
            }).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return driver.findElements(elementLocator).size() > 0;
                }
            });
        } catch (Exception var5) {
            String ErrorMsg = "Failed wait for Element Present [" + elementLocator + "] request within timeout of : " + timeout + " seconds  at url:" + driver.getCurrentUrl();
            log(ErrorMsg);
            StackTraceElement ste = (new Exception()).getStackTrace()[1];
            log(ste.getClassName() + "/" + ste.getMethodName() + ":" + ste.getLineNumber());
            Assert.assertTrue(false);
            return false;
        }

        log("Verify Element Is Present on the UI : Passed ");
        Assert.assertTrue(true);
        return true;
    }

    public  void select(WebElement element,String value) {
        Select sle = new Select(element);
        sle.selectByValue(value);
    }

    public void scrollBottom() {
        log("Attempting to scroll to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight); return true", new Object[0]);

        try {
            wait(2);
        } catch (Exception var3) {
        }

    }
}
