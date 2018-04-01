import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class L120_AppTest {

    @Test //01
    public static void myTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/chromedriver");

        WebDriver browser = new ChromeDriver();

        browser.get("https://www.random.org/integers/");
        Thread.sleep(1500);

        // $("input[value = 'Get Numbers']");
        //browser.findElement(By.cssSelector("input[value = 'Get Numbers']"));

        WebElement maxNumberInput = browser.findElement(By.cssSelector("input[name = 'max']"));
        maxNumberInput.clear();
        maxNumberInput.sendKeys("1000");


        WebElement getNumbersButton = browser.findElement(By.cssSelector("input[value = 'Get Numbers']"));
        getNumbersButton.click();

        WebElement generateNumbers = browser.findElement(By.cssSelector("pre[class = 'data']"));
        String numbers = generateNumbers.getText();

        System.out.println(numbers);

        Thread.sleep(2500);

        browser.quit();

        Assert.assertTrue(numbers.length() > 0, "Negative case message");

    }


}
