import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mahesh.kafle\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
        List<WebElement> radio_btns = driver.findElements(By.xpath("//input[@name='lang' and @Type='radio']"));
        for(int i=0; i <radio_btns.size(); i++){
            WebElement ele = radio_btns.get(i);
            String value = ele.getAttribute("value");
            System.out.println("value===>>>>>>>"+value);
            if(value.equalsIgnoreCase("RUBY")){
                ele.click();
            }
        }
    }
}
