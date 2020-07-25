package com.mystore.testCases;
import org.testng.annotations.Test;
import com.mystore.pageObjects.SignInPage;
import org.testng.Assert;

import java.io.IOException;

public class TC_Login extends TestManager {


    @Test
    public void loginTest() throws IOException {
        super.setup();

        driver.get(signInURL);
        logger.info("URL is opened");

        driver.manage().window().maximize();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail(email);
        logger.info("Entered username");

        signInPage.enterPassword(password);
        logger.info("Entered password");

        signInPage.clickSignInButton();

        if(driver.getTitle().equals("My account - My Store")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }else {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
        super.closeDown();
    }

}
