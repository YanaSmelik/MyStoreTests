package com.mystore.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestManager {

    public String baseURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public String emailAddress = "yanatest@mail.com";
    public String password = "123-QAZxsw";
    public static WebDriver driver;
    public static Logger logger;


    public void setup() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        logger = Logger.getLogger("MyStore");
        PropertyConfigurator.configure("log4j.properties");
    }


    public void closeDown(){
        driver.quit();
    }




}
