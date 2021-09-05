package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavascriptExecutorConcept {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic waits
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);

        System.out.println("Title of page before login:====>>"+driver.getTitle());

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        // driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();
       WebElement loginBtn =  driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]"));

       flash(loginBtn, driver);

    }

    public static void flash(WebElement locator, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = locator.getCssValue("backgroundColor");
        for(int i=0; i< 10; i++){
            changeColor("rgb(0,0,200)", locator, driver);
            changeColor(bgcolor, locator, driver);
        }
    }

    public static void changeColor(String color, WebElement locator, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",locator);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){

        }
    }
}
