package TestNg.CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        // Check if param passed from TestNG is "FireFox"
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }

        // Check if param passed from TestNG is "Chrome"
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }

        // Check if param passed from TestNG is "Edge"
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            driver = new EdgeDriver();
        }

        else {
            throw new Exception("Browser is not correct!!");
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testParameterWithXML() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement uname = driver.findElement(By.id("username"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement Login = driver.findElement(By.className("radius"));
        uname.sendKeys("tomsmith");
        pwd.sendKeys("SuperSecretPassword!");
        Login.click();
        Thread.sleep(2000);
        WebElement div = driver.findElement(By.id("flash"));
        String expectedTextMessage = "You logged into a secure area!\n" + "×";
        String actualTextMessage = div.getText();
        // System.out.println("actualTextMessage->>>>"+ actualTextMessage);
        Assert.assertEquals(expectedTextMessage, actualTextMessage);
        Thread.sleep(3000);
        driver.close();

    }
}
