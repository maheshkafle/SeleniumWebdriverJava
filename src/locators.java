import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Launch Chrome
        driver.get("https://opensource-demo.orangehrmlive.com/"); //open the url
        String title = driver.getTitle(); // get title
        System.out.println(title);


        // 1. XPath
        // Interview Question:
        By uname_xpath = By.xpath("//*[@id='firstName']"); // By class xpath method
        WebElement firstname_xpath= driver.findElement(uname_xpath);
        WebElement lastname_xpath = driver.findElement(By.xpath("//*[@id='lastName']"));

        firstname_xpath.sendKeys("Mahesh");
        lastname_xpath.sendKeys("Kafle");

        // 2. By name
        WebElement uname_name = driver.findElement(By.name("txtUsername"));
        WebElement pwd_name = driver.findElement(By.name("txtPassword"));

        uname_name.sendKeys("Admin");
        pwd_name.sendKeys("admin123");

        // 3. By classname
        WebElement button_class = driver.findElement(By.className("button"));
        button_class.click();

        // 4. By id

        WebElement firstname_id= driver.findElement(By.id("txtUsername"));
        WebElement lastname_id = driver.findElement(By.id("txtPassword"));
        firstname_id.sendKeys("Admin");
        lastname_id.sendKeys("admin123");

        // 5. By css
        WebElement firstname_css= driver.findElement(By.cssSelector("#txtUsername"));
        WebElement lastname_css = driver.findElement(By.cssSelector("#txtPassword"));
        firstname_css.sendKeys("Admin");
        lastname_css.sendKeys("admin123");

    }
}
