import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mahesh.kafle\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://demoqa.com/automation-practice-form"); //open the url
        String title = driver.getTitle(); // get title
        System.out.println(title);


        // 1. XPath
        WebElement firstnameField= driver.findElement(By.id("firstName"));
        WebElement lastnameField = driver.findElement(By.id("lastName"));

        firstnameField.sendKeys("Mahesh");
        lastnameField.sendKeys("Kafle");
//        driver.quit();

    }
}
