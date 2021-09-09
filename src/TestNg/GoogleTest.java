package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;


public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // dynamic waits
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(3000);
        driver.get("http://google.com");
    }

    @Test
    public void getTitleTest(){
        String expectedTitle = "Google";
        String ActualTitle = driver.getTitle();
        // System.out.println(ActualTitle);
        Assert.assertEquals(expectedTitle, ActualTitle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
