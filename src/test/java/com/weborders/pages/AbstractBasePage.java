package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * It meant to be extended
 */
public abstract class AbstractBasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,25);

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    @FindBy(tagName = "h2")
    protected WebElement pageSubtitle;


    public String getPageSubtitleText(){
        BrowserUtilities.waitForPageToLoad(10);
        return pageSubtitle.getText().trim();
    }

    public String getPageLogoText(){

        return pageLogo.getText();
    }

    public AbstractBasePage(){
        //For @FindBy
        PageFactory.initElements(Driver.getDriver(),this);

    }

    /**
     * Specify component name as a parameter, like : View all orders, View all products or Order
     * @param component
     */
    public void navigateTo(String component){
        String locator = "//a[text()='" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

}
