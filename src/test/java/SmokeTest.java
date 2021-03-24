import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest {
    WebDriver webDriver;

//    public String takeEmail(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headles");
//        webDriver = new ChromeDriver(options);
//        webDriver.get("https://10minutemail.net/?lang=tr");
//
//        String mail = webDriver.findElement(By.cssSelector(".mailtext")).getText();
//        System.out.println(mail);
//        return mail;
//    }

    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atari\\Desktop\\Projects\\chromedriver.exe");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.trendyol.com");

        webDriver.findElement(By.className("fancybox-close"))
                .click();
    }
    @Test
    public void goTest(){
//        webDriver.findElement(By.className("signup-button"))./click();
        webDriver.findElement(By.cssSelector("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user > p")).click();
        webDriver.findElement(By.cssSelector(".q-secondary.q-button-medium.q-button.tab.button.right")).click();
        webDriver.findElement(By.cssSelector("#register-email")).sendKeys("xvn69006@eoopy.com");
        webDriver.findElement(By.cssSelector("#register-password-input")).sendKeys("testdeneme123");

        webDriver.findElement(By.cssSelector(".q-gray.q-fluid.q-button-medium.q-button.male")).click();
        webDriver.findElement(By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit")).click();
        webDriver.findElement(By.cssSelector(".modal-close")).click();
//        webDriver.findElement((By.cssSelector("a[href='/tv-goruntu-ses-sistemleri-x-c104035']"))).click();
        webDriver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[9]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div[2]/div[1]/div[1]/article[1]/a/span/img")).click();
        String URLpage3 = webDriver.getCurrentUrl() + "?pi=3";
        webDriver.get(URLpage3);
//        webDriver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/a/div[1]/div/img")).click();
        webDriver.findElement(By.xpath("//*[@id=\"boutique-detail-app\"]/div/div[2]/div/div[1]/a/div[1]/img")).click();
        webDriver.findElement(By.cssSelector(".add-to-bs-tx")).click();
//        webDriver.findElement(By.cssSelector(".link account-basket"))
        webDriver.findElement(By.cssSelector("#account-navigation-container > div > div.account-nav-item.basket-preview > a")).click();

        boolean itemIsAdded = webDriver.findElement(By.cssSelector(".pb-basket-item")).isDisplayed();
        assertEquals(itemIsAdded , true);
    }
    /*
    @Test
    public void goProduct(){
        webDriver.findElement((By.cssSelector("a[href='/tv-goruntu-ses-sistemleri-x-c104035']"))).click();
        String currentURL = webDriver.getCurrentUrl();
        System.out.println(currentURL);
    }
*/
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
