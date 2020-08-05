package com.mystore.testCases;

import com.mystore.pageObjects.CommonElements;
import com.mystore.pageObjects.CreateAccountPage;
import com.mystore.pageObjects.MyAccountPage;
import com.mystore.pageObjects.SignInPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;


public class TC_CreateAccount extends TestManager {

    @Test
    public void createAccount() throws IOException {
        super.setup();
        driver.get(signInURL);
        logger.info("URL is opened");

        driver.manage().window().maximize();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailCreateAccount("joetest10@mail.com");
        signInPage.clickCreateAccountButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(createAccountPage.getMrRadioButton()));

        createAccountPage.clickMrRadioButton();
        createAccountPage.enterFirstName("Joe");
        logger.info("First name is provided");
        createAccountPage.enterLastName("Welsh");
        logger.info("Last name is provided");
        createAccountPage.enterPassword(password);
        logger.info("Password is provided");
        createAccountPage.selectFromDays("2");
        createAccountPage.selectFromMonths("2");
        createAccountPage.selectFromYears("1985");
        logger.info("Date is provided");
        createAccountPage.clickNewsletterCheckBox();
        createAccountPage.clickSpecialOffersCheckBox();
        createAccountPage.enterCompany("Test");
        logger.info("Company name is provided");
        createAccountPage.enterAddress1("614 Risus. Av, P.O. Box 116, Test");
        logger.info("First address is provided");
        createAccountPage.enterAddress2("Test Air, Unit 5 The Merlin Center");
        logger.info("Second address is provided");
        createAccountPage.enterCity("Mesa");
        logger.info("City is provided");
        createAccountPage.selectFromStates("3");
        logger.info("State is selected");
        createAccountPage.enterZip("85203");
        logger.info("Zip code is provided");
        createAccountPage.selectFromCountries("21");
        logger.info("Country is selected");
        createAccountPage.enterHomePhone("(567)321-6645");
        logger.info("Home phone is provided");
        createAccountPage.enterMobilePhone("+1-202-555-0134");
        logger.info("Mobile phone is provided");
        createAccountPage.enterAddressAlias("TestAdr");
        logger.info("Email alias is provided");
        createAccountPage.clickRegisterButton();
        logger.info("Registration data is submitted");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        boolean isSuccessful = myAccountPage.getOrderHistoryButton().isDisplayed();
        if (isSuccessful) {
            Assert.assertTrue(true);
            logger.info("createAccount test PASSED");
        } else {
            captureScreen(driver, "createAccount");
            Assert.assertTrue(false);
            logger.info("createAccount test FAILED");
        }

        CommonElements commonElements = new CommonElements(driver);
        commonElements.clickSignOutButton();

        super.closeDown();
    }
}
