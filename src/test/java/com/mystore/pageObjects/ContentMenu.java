package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentMenu {

    WebDriver driver;

    public ContentMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WOMEN section
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    @CacheLookup
    WebElement womenSection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/a")
    @CacheLookup
    WebElement topsSubsection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
    @CacheLookup
    WebElement tShirts;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
    @CacheLookup
    WebElement blouses;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/a")
    @CacheLookup
    WebElement dressesSubsection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    @CacheLookup
    WebElement dressesCasual;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    @CacheLookup
    WebElement eveningDresses;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    @CacheLookup
    WebElement summerDresses;


    // DRESSES section
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    @CacheLookup
    WebElement dressesSection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    @CacheLookup
    WebElement casualDressesSubSection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    @CacheLookup
    WebElement eveningDressesSubSection;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    @CacheLookup
    WebElement summerDressesSubSection;


    // T-SHIRTS section
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    @CacheLookup
    WebElement tShirtsSection;




    public void clickWomenSection(){
        womenSection.click();
    }

    public void clickTopsSubsection(){
        topsSubsection.click();
    }

    public void clickTShirts(){
        tShirts.click();
    }

    public void clickBlouses(){
        blouses.click();
    }

    public void clickDressesSubsection(){
        dressesSubsection.click();
    }

    public void clickDressesCasual(){
        dressesCasual.click();
    }

    public void clickEveningDresses(){
        eveningDresses.click();
    }

    public void clickSummerDresses(){
        summerDresses.click();
    }

    public void clickDressesSection(){
        dressesSection.click();
    }

    public void clickCasualDressesSubSection(){
        casualDressesSubSection.click();
    }

    public void clickEveningDressesSubSection(){
        eveningDressesSubSection.click();
    }

    public void clickSummerDressesSubSection(){
        summerDressesSubSection.click();
    }

    public void clickTShirtsSection(){
        tShirtsSection.click();
    }
}
