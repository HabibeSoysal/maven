package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03CAlışmam extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("http:s//facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Temmuz").sendKeys(Keys.TAB).sendKeys("1984").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).perform();

    }
}
