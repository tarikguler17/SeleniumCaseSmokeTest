package com.trendyol.seleniumCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ItemPage extends BasePage {
    private By resultTextBy = By.cssSelector(".dscrptn>h1");
    private By itemBy = By.cssSelector("a[href='/rampage/rm-k27-x-jammer-3-5-mm-7-renk-ledli-gaming-oyuncu-mikrofonlu-kulaklik-p-46396877']");
    private By itemTextBy = By.cssSelector("a[href='/rampage/rm-k27-x-jammer-3-5-mm-7-renk-ledli-gaming-oyuncu-mikrofonlu-kulaklik-p-46396877']>* .p-card-img");
    private By basketBy = By.cssSelector(".link.account-basket");
    private By spanText = By.cssSelector(".pr-new-br>span");

    public ItemPage(WebDriver webDriver) { super(webDriver); }
    

    public String getResultText() {
        return webDriver.findElement(resultTextBy).getText();
    }

    public void goThirdPage(){
        String thirdPageUrl = webDriver.getCurrentUrl()+"?pi=3";
        webDriver.get(thirdPageUrl);
        try {
          webDriver.findElement(By.cssSelector(".overlay")).click();

        }catch (NoSuchElementException e){   }
    }

    public String getItemText() {
        return webDriver.findElement(itemTextBy).getAttribute("alt");
    }
    public String getSpanText(){
        return getText(spanText).substring(0,30);
    }

    public void clickItem(){
        click(itemBy,5);
    }

    public void goSecondTab(){
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
    }
    public void addItemToBasket(){
        click(By.cssSelector(".add-to-bs-tx"),5);
    }
    public BasketPage getBasketPage(){
        click(basketBy,5);
        return new BasketPage(webDriver);
    }
}

