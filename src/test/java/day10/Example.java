package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Example extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        // 1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle=driver.getWindowHandle();

        // 2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
// mouse’u bu menunun ustune getirelim
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();

        // 3 “Create a list” butonuna basalim

       driver.findElement(By.xpath("//*[text()='Create a List']")).click();

// 4 Acilan sayfada “Your Lists” yazisi oldugun

        Assert.assertTrue(driver.findElement(By.xpath("//*[@aria-level='1']")).isDisplayed());
    }
}
