package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage {

    WebDriver driver;

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    @CacheLookup
    WebElement productItem;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
    @CacheLookup
    WebElement addToCartButton;


    public void hoverOverProductItem() {
        Actions action = new Actions(driver);
        action.moveToElement(productItem).perform();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }
}
