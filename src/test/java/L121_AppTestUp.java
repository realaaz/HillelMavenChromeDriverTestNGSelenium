import com.sun.xml.internal.bind.v2.TODO;
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
    public void myTest() throws InterruptedException {

        browser.get("https://www.random.org/integers/");

        // set area of integers
        WebElement numberOfIntegers = browser.findElement(By.cssSelector("input[name = 'num']"));
        numberOfIntegers.clear();
        numberOfIntegers.sendKeys("1");

        // get min / max data
        String numbersMax = browser.findElement(By.cssSelector("input[name = 'max']")).getAttribute("value").replaceAll("\n", " ");
        String numbersMin = browser.findElement(By.cssSelector("input[name = 'min']")).getAttribute("value").replaceAll("\n", " ");;

        //cssSelector("*[attributeName='value']"))

        // go to result page
        browser.findElement(By.cssSelector("input[value = 'Get Numbers']")).click();

        // find generated data
        String numbers = browser.findElement(By.cssSelector("pre[class = 'data']")).getText();

        System.out.println(numbersMin + " | " + numbersMax + " | "  + numbers);

        // convert to int
        int numbersInt = Integer.parseInt(numbers.replaceAll( "[^\\d]", "" ));;
        int numbersMaxInt = Integer.parseInt(numbersMax.replaceAll( "[^\\d]", "" ));;
        int numbersMinInt = Integer.parseInt(numbersMin.replaceAll( "[^\\d]", "" ));;
        //System.out.print(numbersInt);

        // assert: is that new int within mix (0) / max (10->100)
        Assert.assertTrue(numbersInt >= numbersMinInt && numbersInt <= numbersMaxInt, "Negative case message: ");

    }


}
