package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

   static WebDriver driver;

   @BeforeClass

    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }

@AfterClass
    public void tearDown() {
        //driver.close();
}

@Test
    public void test1(){
        //  * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    String expectedTitle="Youtube";
    String actualTitle= driver.getTitle();
   Assert.assertEquals(expectedTitle,actualTitle);

}
    @Test
    public void test2(){
// * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement imageTest = driver.findElement(By.xpath("//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(imageTest.isDisplayed());
        System.out.println("-------------");
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id='logo-icon'])[1]")).isDisplayed());

    }
    @Test
    public void test3() {
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())(//*[@id=\"search\"])[3]
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id=\\\"search\\\"])[3]")).isEnabled());

    }
    @Test
    public void test4() {

// wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String expectedTitle="youtube";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));


}
}
