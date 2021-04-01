package com.trendyol.seleniumCase;

import com.trendyol.seleniumCase.pages.HomePage;
import com.trendyol.seleniumCase.pages.SignupPage;
import com.trendyol.seleniumCase.users.User;
import com.trendyol.seleniumCase.users.UserPool;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest {
    @Test
    public void shouldSignup() {
        HomePage homePage = new HomePage(webDriver);
        SignupPage signupPage = homePage.getSignupPage();

        User user = UserPool.getUser1();
        homePage = signupPage.signup(user);

        String accountButtonText = homePage.getAccountText();
        assertEquals(accountButtonText, "Hesabım");
    }

}
