package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        //WebElement alert_button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //WebElement alert_button = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement alert_button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alert_button.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Message : "+ alertMessage);
        alert.accept();
        //alert.dismiss(); // Hint: after execution of line no 26 it will click on cancel button of alert box.
        Thread.sleep(5000);
        driver.quit();
    }
}
