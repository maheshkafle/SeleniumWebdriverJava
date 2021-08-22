package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.Thread;


public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("http://google.com");
    }

    @Test
    public void getTitleTest(){
        String title = driver.getTitle();
        System.out.println(title);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
