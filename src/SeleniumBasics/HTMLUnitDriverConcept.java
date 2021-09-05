package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

    public static void main(String[] args) throws InterruptedException {
        /*
        * HTMLunitdriver is not available in Selenium 3.x version
        * HTMLunitdriver -- to use this concept, we have to download external HTMLunitdriver jar file.
        * Advantages
        *  1. Testing happens behind the scene, no browser involvement
        *  2. Execution of test cases is very fast, performance of script becomes faster
        *  3. Performance improves
        * It is not suitable for Action CLass like mousemovement, draganddrop and doubleclick
        * This is also called Ghost Driver/ Headless Browser/ because it is not visible
        * HTMLunitdriver(java), phantomjs(headless browser for js)
        * */

         //WebDriverManager.chromedriver().setup();
         //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic waits
        // driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);

        System.out.println("Title of page before login:====>>"+driver.getTitle());

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(5000);

        System.out.println("Title of page after login:====>>"+driver.getTitle());

    }
}
