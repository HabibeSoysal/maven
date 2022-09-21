package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfterClass;

public class C02_IlkTestBaseClass extends TestBaseBeforeAfterClass {
    @Test
    public void test1() {
        driver.get("https://amazon.com");
    }
}