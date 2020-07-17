package com.mystore.testCases;

import com.mystore.pageObjects.SignInPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TC_Login extends TestManager {


    @Test
    public void loginTest() {
        super.setup();

        driver.get(baseURL);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(emailAddress);
        signInPage.enterPassword(password);
        signInPage.clickSignInButton();

        Assert.assertTrue(driver.getTitle().equals("My account - My Store"));

        super.closeDown();
    }

}
