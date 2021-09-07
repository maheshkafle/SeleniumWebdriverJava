package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapDropdownHandle {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.findElement(By.className("btn-group")).click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getText());
            // to select all dropdown
            // list.get(i).click();
            // to select particular drop down
            if(list.get(i).getText().contains("Angular")){
                list.get(i).click();
                break;
            }
        }
    }
}
