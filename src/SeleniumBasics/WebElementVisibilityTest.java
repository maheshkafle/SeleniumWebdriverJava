package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebElementVisibilityTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize the window
        driver.manage().deleteAllCookies(); // delete all cookies

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://classic.freecrm.com/register/");

        // 1. isDisplayed(): It is applicable for all web elements
        boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
        System.out.println(b1); //true

        // 2. isEnabled(): checks if web element is enabled or not
        boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b2); // false

        // select consent checkbox
        driver.findElement(By.name("agreeTerms")).click();
        boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b3); // true

        // isSelected(): Method applicable only for checkbox, dropdown and radiobutton
        boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b4); // true

        driver.findElement(By.name("agreeTerms")).click();
        boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b5); // false


    }
}
