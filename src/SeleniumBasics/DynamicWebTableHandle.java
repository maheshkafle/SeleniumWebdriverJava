package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicWebTableHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");

        driver.findElement(By.name("username")).sendKeys("smarshqa");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().frame("mainpanel");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]")).click();

        // xpaths of contacts name in dynamic web table
        //*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
        //*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
        //*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
        //*[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a

        // Method 1
        // String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
        // String after_xpath = "]/td[2]/a";

        // for(int i=4; i<=7; i++){
        //    String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
        //    System.out.println(name);

        //    if(name.contains("test1 test2")){
        //        driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
        //    }
        //}

        // Method 2:
        driver.findElement(By.xpath("//a[contains(text(), 'test1 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'smarshqa mahesh2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();


    }
}
