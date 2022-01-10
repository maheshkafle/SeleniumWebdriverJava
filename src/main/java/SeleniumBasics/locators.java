package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class locators {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://opensource-demo.orangehrmlive.com/"); //open the url
        // Hint: For LinkText and PartialLinkText Locator use below url for debugging purpose: http://the-internet.herokuapp.com/redirector
        driver.manage().window().maximize();
        String title = driver.getTitle(); // get title
        System.out.println(title);


        // 1. XPath
        // Interview Question:
        By uname_xpath = By.xpath("//*[@id='txtUsername']"); // By class xpath method
        WebElement firstname_xpath= driver.findElement(uname_xpath);
        WebElement lastname_xpath = driver.findElement(By.xpath("//*[@id='txtPassword']"));

        firstname_xpath.sendKeys("Mahesh");
        lastname_xpath.sendKeys("Kafle");
        Thread.sleep(3000);

        // 2. By name
        WebElement uname_name = driver.findElement(By.name("txtUsername"));
        WebElement pwd_name = driver.findElement(By.name("txtPassword"));

        uname_name.clear();
        uname_name.sendKeys("Admin");
        pwd_name.clear();
        pwd_name.sendKeys("admin123");
        Thread.sleep(3000);

        // 3. By id

        WebElement firstname_id= driver.findElement(By.id("txtUsername"));
        WebElement lastname_id = driver.findElement(By.id("txtPassword"));
        firstname_id.clear();
        firstname_id.sendKeys("Admin");
        lastname_id.clear();
        lastname_id.sendKeys("admin123");

        // 4. By css
        WebElement firstname_css= driver.findElement(By.cssSelector("#txtUsername"));
        WebElement lastname_css = driver.findElement(By.cssSelector("#txtPassword"));
        firstname_css.clear();
        firstname_css.sendKeys("Admin");
        lastname_css.clear();
        lastname_css.sendKeys("admin123");

        // . By LinkText
//        WebElement link_element = driver.findElement(By.linkText("here"));
//        Thread.sleep(4000);
//        link_element.click();
//        System.out.println("Clicked LinkText");

        // By PartialLinkText
//        WebElement partial_link_text = driver.findElement(By.partialLinkText("Elemental"));
//        Thread.sleep(4000);
//        partial_link_text.click();
//        System.out.println("Clicked Partial Link Text");

        // . By classname
        WebElement button_class = driver.findElement(By.className("button"));
        button_class.click();


        Thread.sleep(4000);

        driver.quit();
    }
}
