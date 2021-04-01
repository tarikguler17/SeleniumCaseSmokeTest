package com.trendyol.seleniumCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private By itemText = By.cssSelector(".pb-item");

    public BasketPage(WebDriver webDriver) { super(webDriver); }

    public String getItemText(){
        return webDriver.findElement(itemText).getAttribute("title");
    }
}
