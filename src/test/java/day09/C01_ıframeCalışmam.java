package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ıframeCalışmam {
    /*



    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
      dogrulayin ve konsolda yazdirin
  */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test001() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.


        driver.get(" https://the-internet.herokuapp.com/iframe");
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isEnabled());
        System.out.println("iframeYazisi.getText() = " + iframeYazisi.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.

        WebElement textBox = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBox);
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear();
        Thread.sleep(5000);
        textBoxFrame.sendKeys("Merhaba Dunya!");
        //     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //         dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent();
        WebElement elementalSelenium= driver.findElement(By.id("page-footer"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("elementalSelenium.getText() = " + elementalSelenium.getText());

    }
}
