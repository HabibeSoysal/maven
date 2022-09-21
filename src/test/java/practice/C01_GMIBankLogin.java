package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) throws InterruptedException {
        //https://www.gmibank.com/ adresine gidin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.gmibank.com/");

        //2- sign in butonuna tıkla
        driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-user fa-w-14 ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Sign in'])[1]")).click();
        driver.close();

//3 username:Batch81, PAssword:Batch81+
        driver.findElement(By.cssSelector("#username")).sendKeys("Batch81");
        driver.findElement(By.cssSelector("#password")).sendKeys("Batch81+", Keys.ENTER);


    }
}
