package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartModal {

    WebDriver driver;

    public AddToCartModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "layer_cart")
    @CacheLookup
    WebElement addToCartModalWindow;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    @CacheLookup
    WebElement textOnSuccess;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    @CacheLookup
    WebElement proceedToCheckoutButton;

    public WebElement getAddToCartModalWindow(){
        return addToCartModalWindow;
    }

    public String getTextOnSuccess(){
        return textOnSuccess.getText();
    }

    public WebElement getProceedToCheckoutButton(){
        return proceedToCheckoutButton;
    }

    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}
