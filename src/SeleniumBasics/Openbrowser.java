package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openbrowser {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://www.google.com/");
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
