package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.lang.Thread;

public class dropdown {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdown_opt = new Select(dropdown);
        // index starts from 0
        dropdown_opt.selectByIndex(1);

        Thread.sleep(3000);

        // hover over selectByValue class we can see it accepts string parameter
        dropdown_opt.selectByValue("2");

        Thread.sleep(3000);

        // visible text is case sensitive
        dropdown_opt.selectByVisibleText("Option 1");

        driver.quit();
    }
}
