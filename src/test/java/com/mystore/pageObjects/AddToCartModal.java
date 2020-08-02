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

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]")
    @CacheLookup
    WebElement addToCartModalWindow;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    @CacheLookup
    WebElement textOnSuccess;

    public WebElement getAddToCartModalWindow(){
        return addToCartModalWindow;
    }

    public String getTextOnSuccess(){
        return textOnSuccess.getText();
    }
}
