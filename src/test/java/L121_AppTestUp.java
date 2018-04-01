import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L121_AppTestUp {

    WebDriver browser;

    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/chromedriver");
        browser = new ChromeDriver();
    }

    @AfterTest
    public void closeChrome(){
        browser.quit();
    }

    @Test //01
    public void myTest() {


        browser.get("https://www.random.org/integers/");

        WebElement maxNumberInput = browser.findElement(By.cssSelector("input[name = 'num']"));
        maxNumberInput.clear();
        maxNumberInput.sendKeys("1");

        browser.findElement(By.cssSelector("input[value = 'Get Numbers']")).click();

        String numbers = browser.findElement(By.cssSelector("pre[class = 'data']")).getText();

        System.out.println(numbers);
        
        // convert to int
        // assert is that new int within mix/max
        Assert.assertTrue(numbers.length() > 0, "Negative case message");

    }


}
