package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01Calışması extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://www.amazon.com");//https://www.amazon.com sayfasina gidelim
//Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(searchBox) .
                sendKeys("samsung").
                sendKeys(" ").
                sendKeys(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
WebElement searchResult= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(searchResult.isDisplayed());


    }
}
