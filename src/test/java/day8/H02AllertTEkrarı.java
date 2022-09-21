package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H02AllertTEkrarı {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {

        //		○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //		“You successfully clicked an alert” oldugunu test edin.

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String actualMessage = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "You successfully clicked an alert";

        Assert.assertEquals(expectedMesaj, actualMessage);
    }

    @Test
    public void test2() throws InterruptedException {

        //		○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //		“successfuly” icermedigini test edin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfuly";
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));


    }

}
