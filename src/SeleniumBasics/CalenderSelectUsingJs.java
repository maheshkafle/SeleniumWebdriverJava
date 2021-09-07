package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalenderSelectUsingJs {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.easemytrip.com/flights.html");

        WebElement locator = driver.findElement(By.id("ddate"));
        String dateVal = "16/09/2021";
        SelectDateByJs(driver, locator, dateVal);


    }

    public static void SelectDateByJs(WebDriver driver, WebElement locator, String dateVal) throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value', '"+dateVal+"');", locator);
        Thread.sleep(5000);
        System.out.println("executed this line");
    }
}
