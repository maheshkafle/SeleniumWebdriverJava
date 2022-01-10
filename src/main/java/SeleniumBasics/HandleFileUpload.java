package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUpload {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement browseBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
        browseBtn.sendKeys("C:\\Users\\kafle\\Downloads\\Resume - Ghanu Kafle.pdf");
        WebElement UploadBtn = driver.findElement(By.xpath("//input[@id='file-submit']"));
        UploadBtn.click();
        WebElement div = driver.findElement(By.cssSelector("div[class='example'] h3"));
        String text = div.getText();
        //System.out.println(text);
        if(text.equalsIgnoreCase("File Uploaded!")){
            System.out.println("Correct! Text Message");
        }
        else {
            System.out.println("Incorrect! Text Message");
        }
        Thread.sleep(4000);
        driver.quit();

    }
}
