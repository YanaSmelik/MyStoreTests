package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    PERSONAL INFORMATION
     */
    @FindBy(id = "uniform-id_gender1")
    @CacheLookup
    WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    @CacheLookup
    WebElement mrsRadioButton;

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement firstNameTextField;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement lastNameTextField;

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailTextField;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement passwordTextField;

    @FindBy(id = "days")
    @CacheLookup
    WebElement daysDropDown;


    @FindBy(id = "months")
    @CacheLookup
    WebElement monthsDropDown;


    @FindBy(id = "years")
    @CacheLookup
    WebElement yearsDropDown;


    @FindBy(id = "newsletter")
    @CacheLookup
    WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    @CacheLookup
    WebElement specialOffersCheckBox;


    /*
    ADDRESS
     */

    @FindBy(id = "firstname")
    @CacheLookup
    WebElement firsNameAddressTextField;

    @FindBy(id = "lastname")
    @CacheLookup
    WebElement lastNameAddressTextField;

    @FindBy(id = "company")
    @CacheLookup
    WebElement companyAddressTextField;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement addressTextField;

    @FindBy(id = "address2")
    @CacheLookup
    WebElement address2TextField;


    @FindBy(id = "city")
    @CacheLookup
    WebElement cityTextField;

    @FindBy(id = "id_state")
    @CacheLookup
    WebElement stateDropDown;

    @FindBy(xpath = "//*[@id=\"id_state\"]/option[4]")
    @CacheLookup
    WebElement state;

    @FindBy(id = "postcode")
    @CacheLookup
    WebElement zipTextField;

    @FindBy(id = "id_country")
    @CacheLookup
    WebElement countryDropDown;

    @FindBy(xpath = "//*[@id=\"id_country\"]/option[2]")
    @CacheLookup
    WebElement country;

    @FindBy(id = "other")
    @CacheLookup
    WebElement additionalInfoTextField;

    @FindBy(id = "phone")
    @CacheLookup
    WebElement homePhoneTextField;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    WebElement mobilePhoneTextField;

    @FindBy(id = "alias")
    @CacheLookup
    WebElement addressAliasTextField;

    @FindBy(id = "submitAccount")
    @CacheLookup
    WebElement registerButton;


    public void clickMrRadioButton() {
        mrRadioButton.click();
    }

    public void clickMrsRadioButton() {
        mrsRadioButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameTextField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailTextField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void selectFromDays(String value) {
        Select daysDropDownSelect = new Select (daysDropDown);
        daysDropDownSelect.selectByValue(value);
    }

    public void selectFromMonths(String value) {
        Select monthsDropDownSelect = new Select (monthsDropDown);
        monthsDropDownSelect.selectByValue(value);
    }

    public void selectFromYears(String value) {
        Select yearsDropDownSelect = new Select (yearsDropDown);
        yearsDropDownSelect.selectByValue(value);
    }

    public void clickNewsletterCheckBox() {
        newsletterCheckBox.click();
    }

    public void clickSpecialOffersCheckBox() {
        specialOffersCheckBox.click();
    }

    public void enterFirstNameAdr(String firstName) {
        firsNameAddressTextField.sendKeys(firstName);
    }

    public void enterLastNameAdr(String lastName) {
        lastNameAddressTextField.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        companyAddressTextField.sendKeys(company);
    }

    public void enterAddress1(String address) {
        addressTextField.sendKeys(address);
    }

    public void enterAddress2(String address) {
        address2TextField.sendKeys(address);
    }

    public void enterCity(String city) {
        cityTextField.sendKeys(city);
    }

    public void selectFromStates(String value) {
        Select stateDropDownSelect = new Select (stateDropDown);
        stateDropDownSelect.selectByValue(value);
    }

    public void enterZip(String zip) {
        zipTextField.sendKeys(zip);
    }

    public void selectFromCountries(String value) {
        Select countryDropDownSelect = new Select (countryDropDown);
        countryDropDownSelect.selectByValue(value);
    }

    public void enterAdditionalInfo(String info) {
        additionalInfoTextField.sendKeys(info);
    }

    public void enterHomePhone(String homePhone) {
        homePhoneTextField.sendKeys(homePhone);
    }

    public void enterMobilePhone(String mobilePhone) {
        mobilePhoneTextField.sendKeys(mobilePhone);
    }

    public void enterAddressAlias(String alias) {
        addressAliasTextField.sendKeys(alias);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

}
