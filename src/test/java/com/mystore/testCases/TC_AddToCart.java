package com.mystore.testCases;

import com.mystore.pageObjects.AddToCartModal;
import com.mystore.pageObjects.ContentMenu;
import com.mystore.pageObjects.SignInPage;
import com.mystore.pageObjects.TShirtsPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddToCart extends TestManager {

    @Test
    public void addToCart() {
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

        ContentMenu contentMenu = new ContentMenu(driver);
        contentMenu.clickTShirtsSection();
        logger.info("Select T-Shirts section");

        TShirtsPage tShirtsPage = new TShirtsPage(driver);
        tShirtsPage.hoverOverProductItem();
        logger.info("Hover on product item");

        tShirtsPage.clickAddToCartButton();
        logger.info("Add product item to the cart");

        if (isModalWindowPresent()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        super.closeDown();
    }

    public boolean isModalWindowPresent() {
        try {
            AddToCartModal addToCartModal = new AddToCartModal(driver);
            addToCartModal.getAddToCartModalWindow().isDisplayed();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
