package com.trendyol.seleniumCase;

import com.trendyol.seleniumCase.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TakeEmail {
    static WebDriver webDriver;

    public static String takeEmail(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://10minutemail.net/?lang=tr");

        String mail = webDriver.findElement(By.cssSelector(".mailtext")).getAttribute("value");
        System.out.println(mail);
        webDriver.quit();
        return mail;
    }
}
