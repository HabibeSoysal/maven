package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        //Extends yaptığımız TestBase Class'da Actions clasını oluşturduğumuz için direk objeyi burda kullandık
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe, dropHere).perform();
        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }

    public static class C01Calışmam117 extends TestBaseBeforeAfter {
        @Test
        public void name() {
            //1 https://www.amazon.com/ adresine gidelim
            driver.get("https://www.amazon.com");
            //Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
            //mouse’u bu menunun ustune getirelim
            WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
            Actions actions = new Actions(driver);
            actions.moveToElement(accountList).perform();

            driver.findElement(By.xpath("//*[text()='Create a List']")).click();
           Assert.assertEquals("Your Lists", driver.findElement(By.xpath("//*[@class='nav-a-content']")).getText());

        }
    }
}