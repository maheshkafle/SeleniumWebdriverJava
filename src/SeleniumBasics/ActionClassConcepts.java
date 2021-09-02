package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionClassConcepts {

    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement browse = driver.findElement(By.className("ga_browse_top_cat"));
        Actions builder = new Actions(driver);
        builder.moveToElement(browse).build().perform();
        WebElement link = driver.findElement(By.linkText("Software Testing"));
        builder.moveToElement(link).build().perform();
        Thread.sleep(3000);
        link.click();
        driver.quit();

    }
}
