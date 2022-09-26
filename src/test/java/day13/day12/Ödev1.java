package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Ödev1 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //“Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement ourProducts = driver.findElement(By.xpath("//*[text()='Our Products']"));
        ourProducts.click();
        //“Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        Thread.sleep(2000);
        //Popup mesajini yazdirin
        String popUpBaslik = driver.findElement(By.xpath("//h4")).getText();
        String popUpIcerik = driver.findElement(By.xpath("//*[@class='modal-body']")).getText();
        System.out.println(popUpBaslik + "\n" + popUpIcerik);
        //“close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String beklenenUrl = "http://webdriveruniversity.com/index.html";
        String asilUrl = driver.getCurrentUrl();
        Assert.assertEquals(asilUrl, beklenenUrl);
}
}
