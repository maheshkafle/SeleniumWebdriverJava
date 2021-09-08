package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessChromeConcept {
    public static void main(String[] args) throws InterruptedException {

        // Using Headless option in Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");

        WebDriverManager.chromedriver().setup();
        //passing options param in ChromeDriver class
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/index.html");

        System.out.println("Title before login: "+driver.getTitle());
        driver.findElement(By.name("username")).sendKeys("smarshqa");
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("===================================");
        System.out.println("Title after login: "+driver.getTitle());

    }
}
