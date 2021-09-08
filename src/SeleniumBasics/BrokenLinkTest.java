package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinkTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // driver.get("https://classic.crmpro.com/index.html");
        driver.get("https://makemysushi.com/");

        //driver.findElement(By.name("username")).sendKeys("smarshqa");
        //driver.findElement(By.name("password")).sendKeys("123456");
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        //driver.switchTo().frame("mainpanel");

        //1. get the list of all links and imgages
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        listOfLinks.addAll(driver.findElements(By.tagName("img")));

        System.out.println("size of full links and images--->" + listOfLinks.size());

        List<WebElement> validLinks = new ArrayList<>();

        //2. iterate listOfLinks and exclude all links and images which doesn't have any href value and which contains javascript in links
        for (int i = 0; i<listOfLinks.size(); i++){
            System.out.println(listOfLinks.get(i).getAttribute("href"));
            // Note: If condition for classicfreecrm site
            //if (listOfLinks.get(i).getAttribute("href")!=null && (! listOfLinks.get(i).getAttribute("href").contains("javascript"))){
            // Note: if condition for makemysushi site
            if (listOfLinks.get(i).getAttribute("href")!=null && (! listOfLinks.get(i).getAttribute("href").contains("mailto"))){
                validLinks.add(listOfLinks.get(i));
            }
        }

        // Print the size of valid links
        System.out.println("size of valid links and images--->"+validLinks.size());

        // check the href url, with httpconnection api
        // 200 - Ok
        // 404 - Not Found
        // 500 - Internal Error
        // 400 - bad request

        for (int j=0; j<validLinks.size(); j++){

            HttpURLConnection connection = (HttpURLConnection) new URL(validLinks.get(j).getAttribute("href")).openConnection();

            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(validLinks.get(j).getAttribute("href")+"---->"+response);

        }
    }
}
