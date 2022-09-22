package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IframeOdev {
    /*   ● Bir class olusturun: IframeTest02
   1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
               2) sayfadaki iframe sayısını bulunuz.
               3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
               4) ilk iframe'den çıkıp ana sayfaya dönünüz
               5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
       tıklay*/
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
    public void name() throws InterruptedException {
        //   1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> iframeSayisi = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iframeSayisi.get(6));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        //   4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //   5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        driver.switchTo().frame(iframeSayisi.get(7));
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}
