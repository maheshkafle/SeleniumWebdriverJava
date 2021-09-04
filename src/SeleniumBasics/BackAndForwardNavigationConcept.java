package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BackAndForwardNavigationConcept  {

    private static Object OutputType;

    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Timeouts
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Top interview questions
        // How will you navigate from site1 to site2 and navigate back to site1 or viceversa
        // This concept is also called forward and backward navigation button simulation
        // difference between .get() and navigate().to()
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();



        driver.get("https://www.amazon.com/");
        driver.navigate().back();

        // Question how will you simulate refreshing page: use refresh()
        driver.navigate().refresh();

        // Top Interview Question: Can we take screenshot in selenium?
        // Yes we can and for that purpose we use getScreenshotAs()
        //Take the screenshot
        //Convert web driver object to TakeScreenshot

        // below code for screenshot is not working as of now
        // File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        // FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        // end code for screenshot


    }
    
}
