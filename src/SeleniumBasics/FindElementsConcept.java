package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsConcept {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Timeouts
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com/");

        // Top Selenium Interview Question:
        // How To? Get all the total count of links present in webpage and print all those links and check for empty links
        // How To? Get text from all those links
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

        // Prints total count of all links
        System.out.println("Total Link Count: "+listOfLinks.size());

        // Gets text present in all those links
        for(int i=0; i<listOfLinks.size(); i++){
            if(!(listOfLinks.get(i).getText().isEmpty())){
                System.out.println("Link "+i+ ": " + listOfLinks.get(i).getText());
            }
            else {
                System.out.println("Empty link no. "+i);
            }
        }

    }
}
