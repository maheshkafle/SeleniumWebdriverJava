package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomXpathConcepts {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Timeouts
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Important Interview Questions
        // absolute xpath: not recommended why?
        // e.g /html/body/header/div/ul[1]/li[1]/span/a
        // 1. Performance Issue
        // 2. not reliable
        // 3. can be changed at any time in future

        driver.findElement(By.xpath("*//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("*//input[@name='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("*//input[@class='button']")).click();

        // Top Interview Questions:

        // How to handle dynamic id or html elements
        // condition 1: id = test_123, test_456, test_test_789_test
        // we should use starts-with or contains() function
        // condition 2: id=1234_test_t, 2345_test_t, 6789_test_t
        // we should use ends-with

        // implementation
        // driver.findElement(By.xpath("*//input[starts-with(@class='button')]")).click();
        // driver.findElement(By.xpath("*//input[ends-with(@class='button')]")).click();
        // driver.findElement(By.xpath("*//input[contains(@class='button')]")).click();
    }
}
