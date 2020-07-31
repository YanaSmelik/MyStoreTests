package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All elements that are present on the site's header menu (at the top)
 */
public class CommonElements {

    WebDriver driver;

    public CommonElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    @CacheLookup
    WebElement signOutButton;

    @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
    @CacheLookup
    WebElement storeLogo;


    public void clickSignOutButton(){
        signOutButton.click();
    }

    public void clickStoreLogo(){
        storeLogo.click();
    }





}
