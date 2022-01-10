package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrameHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> frameElements = driver.findElements(By.tagName("frame"));
        System.out.println("The total number of frames are " + frameElements.size());

        System.out.println(driver.switchTo().frame("frame-top").switchTo().frame("frame-left").findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.switchTo().frame("frame-top").switchTo().frame("frame-middle").findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.switchTo().frame("frame-top").switchTo().frame("frame-right").findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.switchTo().frame("frame-bottom").findElement(By.tagName("body")).getText());
        Thread.sleep(3000);
        driver.quit();

    }
}
