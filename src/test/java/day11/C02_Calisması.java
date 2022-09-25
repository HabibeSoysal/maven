package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Calisması extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
//3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions = new Actions(driver);
        WebElement name = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        name.sendKeys("Habibe");
        actions.sendKeys(Keys.TAB).
                sendKeys("Soysal").
                sendKeys(Keys.TAB).
                sendKeys("hsoysal2023@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("hsoysal2023@gmail.com").
                sendKeys(Keys.TAB).sendKeys("1984").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//4- Kaydol tusuna basalim
driver.findElement(By.xpath("//*[@class='_1lch']")).click();


        System.out.println("------------------");
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //Actions actions = new Actions(driver); // actions objesini burada oluşturalım ki daha sonra lazım olacak
        WebElement isimButonu = driver.findElement(By.xpath("//*[@name='firstname']"));
        isimButonu.sendKeys("abc");
        actions.sendKeys(Keys.TAB).sendKeys("def").sendKeys(Keys.TAB).
                sendKeys("techpro@gmail.com").sendKeys(Keys.TAB).sendKeys("techpro@gmail.com").
                sendKeys(Keys.TAB).sendKeys("sifre123").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("25").
                sendKeys(Keys.TAB).sendKeys("Nis").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE). // Kadın seçeneğini seçmek için space (boşluk) tuşuna bastım
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//*[@class='_1lch']")).click();
    }
}
