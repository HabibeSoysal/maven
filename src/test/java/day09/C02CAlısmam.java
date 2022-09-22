package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.time.Duration;

public class C02CAlısmam {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle= driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)

        driver.switchTo().newWindow(WindowType.WINDOW );
        driver.get("https://www.bestbuy.com");

        String bestBuyHandle= driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle=driver.getTitle();
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searbox= driver.findElement(By.id("twotabsearchtextbox"));
        searbox.sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());


    }
}
