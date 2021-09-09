package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;


public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // dynamic waits
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(3000);
        driver.get("http://google.com");
        System.out.println("Executed setup method");
    }

    // Famous Interview Question: How will you ensure the execution order of the test cases?
    // Answer: We have keyword called priority, using this we can set the priority of our test cases
    // Also every time a test case is executed then along with this @before and @after annotations holding method will also run
    // Famous Interview Question: How will you define grouping in testNG test cases?
    // Answer: We have "groups" keyword.
    @Test(priority = 1,groups="Title")
    public void getTitleTest(){
        String expectedTitle = "Google";
        String ActualTitle = driver.getTitle();
        // System.out.println(ActualTitle);
        Assert.assertEquals(expectedTitle, ActualTitle);
        System.out.println("Executed getTitleTest method");
    }

    @Test(priority = 2, groups="Logo")
    public void googleLogoTest(){
        boolean b = driver.findElement(By.className("lnXdpd")).isDisplayed();
        Assert.assertTrue(b);
        System.out.println("Executed googleLogoTest method");
    }

    @Test(priority = 3, groups="Test")
    public void test1(){
        System.out.println("Executed test1 method");
    }

    @Test(priority = 4, groups="Title")
    public void test2(){
        System.out.println("Executed test2 method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Executed teardown method");
        driver.quit();
    }

}
