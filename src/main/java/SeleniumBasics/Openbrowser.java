package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openbrowser {

    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        if(title.equals("Google")){
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect!");
        }
        driver.quit();

    }

}
