package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03LoginTEst {
    WebDriver driver;
    //1- https://www.koalaresorthotels.com/ sayfasina gidelim
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        @Test
                public void test1() {
           driver.get("https://www.koalaresorthotels.com/");
           //login kısmına tıkla
            driver.findElement(By.xpath("//*[text()='Log in']")).click();
            //driver.findElement(By.cssSelector("#navLogon")).click();

            //3- login ekrarına girdiğinizi 4 faklı webelementı kullanarak yapını
            //a-)
            Assert.assertTrue(driver.getTitle().contains("Log in"));

            //b-
            String expectedUrl="https://www.koalaresorthotels.com/Account/Logon";
            String actualUrl=driver.getCurrentUrl();
            Assert.assertEquals("Login Ekranına Giriş Yapılmadı",expectedUrl,actualUrl);;

            //c-
            WebElement L3=driver.findElement(By.xpath("//*[@id='btSubmit']"));
            Assert.assertTrue(L3.isDisplayed());

            //d-
Assert.assertTrue("Url Yanlis",driver.getCurrentUrl().contains("Logon"));


    }
}
