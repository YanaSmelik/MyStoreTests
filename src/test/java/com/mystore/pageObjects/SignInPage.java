package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailAddressInputField;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    WebElement signInButton;


    public void enterEmailAddress(String emailAddress){
        emailAddressInputField.sendKeys(emailAddress);
    }

    public void enterPassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
