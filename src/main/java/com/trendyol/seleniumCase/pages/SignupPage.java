package com.trendyol.seleniumCase.pages;

import com.trendyol.seleniumCase.TakeEmail;
import com.trendyol.seleniumCase.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.trendyol.seleniumCase.TakeEmail;

public class SignupPage extends BasePage {
    private By emailBy = By.cssSelector("#register-email");
    private By passwordBy = By.cssSelector("#register-password-input");
    private By maleButtonBy = By.cssSelector(".q-gray.q-fluid.q-button-medium.q-button.male");
    private By submitButton = By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit");


    public SignupPage(WebDriver webDriver){ super(webDriver); }

    public HomePage signup(User user){
        sendKeys(emailBy, user.getEmail());
        sendKeys(passwordBy, user.getPassword());
        click(maleButtonBy,5);
        click(submitButton,5);

        HomePage homePage = new HomePage(webDriver);
        homePage.waitForLoad();
        return homePage;


    }


}