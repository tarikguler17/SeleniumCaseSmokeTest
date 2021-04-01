package com.trendyol.seleniumCase.users;

import com.trendyol.seleniumCase.TakeEmail;

public class UserPool extends TakeEmail {

    public static User getUser1() {
        return new User(takeEmail(), "1234qwe");
    }

}
