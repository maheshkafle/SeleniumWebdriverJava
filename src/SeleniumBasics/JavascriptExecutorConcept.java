package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JavascriptExecutorConcept {
    public static void main(String[] args) throws InterruptedException, IOException {

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
        drawBorder(loginBtn, driver);

        // takes screeenshot
        // take screenshot and store it as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\mahesh.kafle\\IdeaProjects\\SeleniumWebdriverJava\\Screenshots\\logo.png"));


    }

    public static void flash(WebElement locator, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = locator.getCssValue("backgroundColor");
        for(int i=0; i< 1; i++){
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

    public static void drawBorder(WebElement locator, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border = '3px solid red'", locator);
    }

}
