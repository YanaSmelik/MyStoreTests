package com.mystore.testCases;

import com.mystore.utils.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TestManager {

    public ReadConfig readConfig = new ReadConfig();
    public String signInURL = readConfig.getSignInURL();
    public String emailAddress = readConfig.getEmailAddress();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;


    public TestManager(){

    }


    public void setup() {
        System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
        driver = new ChromeDriver();
        logger = Logger.getLogger("MyStore");
        PropertyConfigurator.configure("log4j.properties");
    }


    public void closeDown(){
        driver.quit();
    }


    public void captureScreen(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}
