package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionCalısmam extends TestBaseBeforeAfter {
    @Test
    public void name() {
//https://the-internet.herokuapp.com/context_menu sitesine gidelim
driver.get("https://the-internet.herokuapp.com/context_menu");
//Cizili alan bölümün uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

//4 Alert’te cikan yazinin “You selected a context menu” oldugunu
//test edelim.
      String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);
//5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

//Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));
//7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());


    }
}
