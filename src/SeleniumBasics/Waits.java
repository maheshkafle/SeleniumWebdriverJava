package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login"); //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // pageLoadTimeout provides each element at a max of 40 sec to load in a page
        // All implicit, explicit and fluent waits are dynamic waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // Implicitlywait() is applicable for all the elements present in webpage
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Explicit wait is used to tell driver to wait for certain conditions(expected conditions) or max time before throwing
        // "ElementNotVisibleException" exception
        // Third kind of wait is FluentWait which is used to tell driver to wait for a condition, as well as frequency with which
        // we want to check the condition before throwing "ElementNotVisibleException" exception
        WebElement firstname = driver.findElement(By.id("username"));
        WebElement lastname = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("radius"));


        sendKeys(driver, firstname ,10, "tomsmith");
        sendKeys(driver, lastname, 10, "SuperSecretPassword!");

        clickOn(driver, login, 10);

        Thread.sleep(3000);
        driver.quit();

    }

    public static void sendKeys(WebDriver driver1, WebElement element1, int timeout, String value1){
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element1));
        element1.sendKeys(value1);

    }

    public static void clickOn(WebDriver driver2, WebElement element2, int timeout){
        new WebDriverWait(driver2, timeout).until(ExpectedConditions.elementToBeClickable(element2));
        element2.click();
    }
}
