package com.mystore.testCases;

import com.mystore.pageObjects.SignInPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TC_Login extends TestManager {


    @Test
    public void loginTest() {
        super.setup();

        driver.get(baseURL);
        logger.info("URL is opened");

        driver.manage().window().maximize();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(emailAddress);
        logger.info("Entered username");

        signInPage.enterPassword(password);
        logger.info("Entered password");

        signInPage.clickSignInButton();

        if(driver.getTitle().equals("My account - My Store")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }else {
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
        super.closeDown();
    }

}
