package com.mystore.testCases;

import com.mystore.pageObjects.CreateAccountPage;
import com.mystore.pageObjects.MyAccountPage;
import com.mystore.pageObjects.SignInPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.IOException;

public class TC_CreateAccount extends TestManager {

    @Test
    public void createAccount() throws IOException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailCreateAccount("joetest2@mail.com");
        signInPage.clickCreateAccountButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.clickMrRadioButton();
        createAccountPage.enterFirstName("Joe");
        createAccountPage.enterLastName("Welsh");
        createAccountPage.enterEmail("joetest2@mail.com");  // automatically filled
        createAccountPage.enterPassword(password);
        createAccountPage.selectFromDays("1");
        createAccountPage.selectFromMonths("1");
        createAccountPage.selectFromYears("1989");
        createAccountPage.clickNewsletterCheckBox();
        createAccountPage.clickSpecialOffersCheckBox();
        createAccountPage.enterFirstNameAdr("Joe");  // automatically filled
        createAccountPage.enterLastNameAdr("Welsh");  // automatically filled
        createAccountPage.enterCompany("Test");
        createAccountPage.enterAddress1("614 Risus. Av, P.O. Box 116, Test");
        createAccountPage.enterAddress2("Test Air, Unit 5 The Merlin Center");
        createAccountPage.enterCity("Mesa");
        createAccountPage.selectFromStates("3");
        createAccountPage.enterZip("85203");
        createAccountPage.selectFromCountries("21");
        createAccountPage.enterHomePhone("(567)321-6645");
        createAccountPage.enterMobilePhone("+1-202-555-0134");
        createAccountPage.enterAddressAlias("TestAdr");
        createAccountPage.clickRegisterButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        boolean isSuccessful = myAccountPage.getOrderHistoryButton().isDisplayed();
        if(isSuccessful){
            Assert.assertTrue(true);
        }else{
            captureScreen(driver, "createAccount");
            Assert.assertTrue(false);
        }




    }
}
