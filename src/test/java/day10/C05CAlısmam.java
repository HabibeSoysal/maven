package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05CAlısmam extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragME=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragME, dropHere).perform();
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
