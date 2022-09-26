package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_calisması extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //product bölümüne  girelim
        Actions actions = new Actions(driver);
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();


    }
}
