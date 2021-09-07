package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CalenderSelectTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic Waits
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/index.html");

        driver.findElement(By.name("username")).sendKeys("smarshqa");
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().frame("mainpanel");

        String date = "32-September-2021";
        String dateArr[] = date.split("-"); //{30, September, 2021}
        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];

        Select select = new Select(driver.findElement(By.name("slctMonth")));
        select.selectByVisibleText(month);

        Select select1 = new Select(driver.findElement(By.name("slctYear")));
        select1.selectByVisibleText(year);

        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]

        String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
        String afterXpath = "]/td[";

        final int totalWeekDays = 7;

        boolean flag = false;
        String dayVal = null;
        for(int rowNum = 2; rowNum <= 7; rowNum++){

            for(int colNum = 1; colNum <= totalWeekDays; colNum++){

                try {
                    dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
                }
                catch (NoSuchElementException e) {
                    System.out.println("Please enter a correct value");
                    flag=false;
                    break;
                }
                System.out.println(dayVal);
                if (dayVal.equals(day)) {
                    driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
                    flag=true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }

    }
}
