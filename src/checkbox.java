import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class checkbox {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
        List<WebElement> checkboxe = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=0; i<checkboxe.size(); i++){
            WebElement ele = checkboxe.get(i);
            String id = ele.getAttribute("id");
            System.out.println("id-->"+id);
            if(id.equalsIgnoreCase("code")){
                ele.click();
                break;
            }
        }
    }
}
