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

        // generate Alert
        // generateAlert(driver, "There is an issue with login page");

        // refresh the page
        // 1. using selenium
        driver.navigate().refresh();

        //2. using js
        refreshBrowserByJs(driver);

        // getTitle()
        System.out.println(getTitleByJs(driver));

        // get all text present in webpage
        System.out.println(getPageInnerText(driver));

        // scroll Page down
        // scrollPageDown(driver);

        // scrollpage till some webelement is visible
        WebElement locator = driver.findElement(By.partialLinkText("OrangeHRM, Inc"));
        scrollIntoView(locator, driver);

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

    public static void generateAlert(WebDriver driver, String message) throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

    }

    public static void refreshBrowserByJs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        Thread.sleep(3000);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJs(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title").toString();
        return title;
    }

    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public static void scrollIntoView(WebElement locator, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", locator);
    }

}
