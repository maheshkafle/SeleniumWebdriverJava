package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.*;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert_button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        alert_button.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Message : "+ alertMessage);
        alert.accept();
    }
}
