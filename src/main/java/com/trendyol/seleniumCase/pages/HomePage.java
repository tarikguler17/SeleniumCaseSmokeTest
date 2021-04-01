package com.trendyol.seleniumCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By componentListBy = By.className("component-list");
    private By tvTabBy = By.cssSelector("a[href='/tv-goruntu-ses-sistemleri-x-c104035']");
    private By electronicTabBy = By.cssSelector("a[href='/butik/liste/elektronik']");


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentListBy));
    }
    public void waitForLoadHover() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(electronicTabBy));
    }

    public ItemPage clickItemPage() {
        HomePage homePage = new HomePage(webDriver);
//        homePage.click(closePopupBy,5);
        webDriver.get("https://trendyol.com");
        homePage.waitForLoadHover();
        homePage.hoverOver(webDriver.findElement(electronicTabBy));

        homePage.click(tvTabBy,5);
        return new ItemPage(webDriver);
    }
}
