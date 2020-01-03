package day13.examples;

import org.testng.annotations.*;

public class AfterAndBeforeEachMethod {
    @Test
    public void Nationality() {
        System.out.println("Testing test case 1");
    }

    @Test
    public void City() {
        System.out.println("Testing test case 2");
    }

    @Test(enabled = true)
    public void Fee() {
        System.out.println("Testing test case 3");
    }

    @AfterMethod
    public void afterEveryMethod(){
        System.out.println("After each");
    }

    @BeforeMethod
    public void before(){
        System.out.println("Before!");
    }

    @BeforeClass
    public void after(){
        System.out.println("Login");
    }

    @AfterClass
    public void afterEverything(){
        System.out.println("Send Report!");
    }
}
