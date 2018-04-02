import com.sun.xml.internal.bind.v2.TODO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class L122_AppTest_Rozetka {

    WebDriver browser;
    long startTime;

    @BeforeTest
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/chromedriver");
        browser = new ChromeDriver();
        startTime = System.currentTimeMillis();
    }

    @AfterTest
    public void closeChrome() {
        browser.quit();
        System.out.println("Time to execute was: " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    @Test //01
    public void myTest() {

        browser.get("https://rozetka.com.ua/");

        // set search condition
        WebElement numberOfIntegers = browser.findElement(By.cssSelector("input[name = 'text']"));
        numberOfIntegers.clear();
        numberOfIntegers.sendKeys("iPhone");

        // go to result page
        browser.findElement(By.cssSelector("button[class = 'btn-link-i js-rz-search-button']")).click();

        // search need class
        String element = browser.findElement(By.cssSelector("div[class='g-i-tile-i-title clearfix']")).getText().replaceAll("\n", " ");
        System.out.println(element);

        // assert: is that first element equal  ... Apple iPhone 6 ...
        Assert.assertTrue(element.contains("iPhone 6"), "Negative case message: ");

    }


}
