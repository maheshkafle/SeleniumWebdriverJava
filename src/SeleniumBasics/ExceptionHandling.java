package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExceptionHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        Thread.sleep(3000);
        // driver.findElement(By.id("fake")).click();
        // try : code which throws exception

        try{
            // 1. 'NoSuchElementException' Handling
             driver.findElement(By.id("fake")).click();
            // 2. 'NoAlertPresentException' Handling
            // driver.switchTo().alert().accept();
            // 3. 'NoSuchFrameException' Handling
            // driver.switchTo().frame("fakeFrame");
            // 4. 'NoSuchWindowException' Handling
            //driver.switchTo().window("fakewindow");

        }
        // catch: whatever exception try block throws it handles it
        catch (Exception e){
            System.out.println("Exception occured!");
            // despite the fact that exception is handled in catch block! if you want to throw exception then we use throw function
            // throw(e);

        }

        System.out.println("Hello from outside of try catch block");
        driver.close();
    }
}
