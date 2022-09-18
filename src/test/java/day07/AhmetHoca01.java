package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AhmetHoca01 {
    /*amazona gidip 
    dropdown dan books secenegını secıp java aratalım ve
     arama sonuclarının java icerdiğini test edelim
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //dropdown dan bir option secmek için 3 adım vardır
        //1-drowdown u locate edelim
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2. adım bir select objesi olusturup
        // parametre olarak bir önceki adımda locate ettiğimiz ddm yi girelim
        Select select = new Select(dropDownMenu);

        //3/Dropdown da var olan opt'onlardan istediğimiz bir taneyi secelim

        //select.selectByIndex(5);
        select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-int-ship");
//arama kutusuna java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

      WebElement sonucYazisiElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        Thread.sleep(5000);

    }


}
