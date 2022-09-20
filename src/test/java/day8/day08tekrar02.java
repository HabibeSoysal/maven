package day8;

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
import java.util.Locale;

public class day08tekrar02 {
    /*
    Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.


//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
// “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesagge = mesaj.getText();
        String wantedMessage = "You successfully clicked an alert";

        Assert.assertEquals(wantedMessage, actualMesagge);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        System.out.println("mesajı yazdırdık = " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String sonucMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(sonucMesaj.contains(expectedMesaj));
    }
//Bir metod olusturun: sendKeysAlert
        @Test
        public void test03(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Habibe");
        driver.switchTo().alert().accept();
       String sonucYazısı= driver.findElement(By.xpath("//*[@id='result'])")).getText();
       String wantedMessage="Habibe";
       Assert.assertTrue(sonucYazısı.contains(wantedMessage));
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    }
}
