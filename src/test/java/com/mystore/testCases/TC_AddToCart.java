package com.mystore.testCases;

import com.mystore.pageObjects.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_AddToCart extends TestManager {

    @Test
    public void addToCart() throws InterruptedException {
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

        AddToCartModal addToCartModal = new AddToCartModal(driver);

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartModal.getProceedToCheckoutButton()));
        addToCartModal.clickProceedToCheckoutButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartPage.getYourShoppingCartLabel()));

        shoppingCartPage.clickRemoveItemButton();

        Thread.sleep(3_000);

        if(shoppingCartPage.getYourShoppingCartLabel().isDisplayed()){ // TODO fix: element is not attached to the page document
            super.closeDown();
        }else{
            throw new AssertionError();
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
