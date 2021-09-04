package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigPropertyConcept {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\mahesh.kafle\\IdeaProjects\\SeleniumWebdriverJava\\src\\SeleniumBasics\\config.properties");

        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("browsername"));

        if(prop.getProperty("browsername").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("google.com");
        }




    }
}
