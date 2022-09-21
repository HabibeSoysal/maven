package practice;

import org.junit.*;

public class C02JUnit {//alfabetik calıstırıyo

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");

        //Her classta ilk calısır. 1 kere calısır
    }
    @Before
    public void before() {
        System.out.println("before");
        //her testten önce calısır
    }
    @After
    public void after() {
        //Her testen sonra calısır

    }
    @AfterClass
    public static void afterClass() {// classın sonunda calısır
        System.out.println("After Class");
    }
    @Test
    public void test01(){
        System.out.println("Test 01");

    }

    @Test
    public void test02(){
        System.out.println("Test 02");

    }

    @Test
    public void test03(){
        System.out.println("Test 03");


    }
}
