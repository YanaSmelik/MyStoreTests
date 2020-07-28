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

    @FindBy(id = "email_create")
    @CacheLookup
    WebElement emailCreateAccountTextField;

    @FindBy(id = "SubmitCreate")
    @CacheLookup
    WebElement createAccountButton;

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailInputField;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    WebElement signInButton;


    public void enterEmail(String email){
        emailInputField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void enterEmailCreateAccount(String email){
        emailCreateAccountTextField.sendKeys(email);
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }
}
