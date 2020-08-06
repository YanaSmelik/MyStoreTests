package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    private WebDriver driver;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    @CacheLookup
    WebElement yourShoppingCartLabel;

    @FindBy(xpath = "//*[@id=\"1_1_0_347090\"]")
    @CacheLookup
    WebElement removeItemButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    @CacheLookup
    WebElement yourCartIsEmptyAlert;

    public WebElement getYourShoppingCartLabel(){
        return yourShoppingCartLabel;
    }

    public void clickRemoveItemButton(){
        removeItemButton.click();
    }

    public WebElement getYourCartIsEmptyAlert(){
        return yourCartIsEmptyAlert;
    }
}
