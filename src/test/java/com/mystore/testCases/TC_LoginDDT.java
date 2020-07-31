package com.mystore.testCases;

import com.mystore.pageObjects.CommonElements;
import com.mystore.pageObjects.SignInPage;
import com.mystore.utils.XLUtils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT extends TestManager {

    public TC_LoginDDT() {

    }

    @Test(dataProvider = "TestCredentials")
    public void loginDDTest(String email, String password) {
        super.setup();

        driver.get(signInURL);
        logger.info("URL is opened");

        driver.manage().window().maximize();

        CommonElements commonElements = new CommonElements(driver);
        SignInPage signInPage = new SignInPage(driver);

        signInPage.enterEmail(email);
        logger.info("email is provided");

        signInPage.enterPassword(password);
        logger.info("password is provided");

        signInPage.clickSignInButton();

        if (driver.getTitle().equals("My account - My Store")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
            commonElements.clickSignOutButton();
        } else {
            Assert.assertTrue(false);
            logger.warn("Login test failed");
        }
        super.closeDown();
    }


    /**
     * Gets testing data from the file
     *
     * @return Two-dimensional array of Strings
     * @throws IOException
     */
    @DataProvider(name = "TestCredentials")
    public Object[][] getData() throws IOException {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/java/com/mystore/testData/TestCredentials.xlsx";

        int rowsTotalNum = XLUtils.getRowsTotalNum(dataFilePath, "Sheet1");
        int columnsTotalNum = XLUtils.getCellsNumber(dataFilePath, "Sheet1", 2);

        String loginCredentials[][] = new String[rowsTotalNum][columnsTotalNum];

        for (int row = 1; row <= rowsTotalNum; row++) {
            for (int column = 0; column < columnsTotalNum; column++) {
                loginCredentials[row - 1][column] = XLUtils.getCellData(dataFilePath, "Sheet1", row, column);
            }
        }
        return loginCredentials;
    }
}
