package com.trendyol.seleniumCase.pages;

import com.trendyol.seleniumCase.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebDriverHelper {

    private By accountButtonBy = By.cssSelector(".account-user");
    private By signupButtonBy = By.cssSelector(".q-secondary.q-button-medium.q-button.tab.button.right");
    private By accountTextBy = By.cssSelector(".account-user");

    public BasePage(WebDriver webDriver) { super(webDriver); }

    public SignupPage getSignupPage() {
        click(accountButtonBy,5);
        click(signupButtonBy,5);

        return new SignupPage(webDriver);
    }
    public String getAccountText() {
        return getText(accountTextBy);
    }

}

