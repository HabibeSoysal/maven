package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class c04_calısmam {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//● Sayfa başlığının(title) “The Internet” olduğunu doğrul
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        Thread.sleep(3000);

//Click Here butonuna basın.
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowList = " + windowList);
        driver.switchTo().window(windowList.get(1));
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Assert.assertTrue(driver.getTitle().contains("New Window"));
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());


    }
}