package day13.examples;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeEveryMethod {

    @Test
    public void TestCase1() {
        System.out.println("Testing test case 1");
    }

    @Test
    public void TestCase2() {
        System.out.println("Testing test case 2");
    }

    @Test
    public void TestCase3() {
        System.out.println("Testing test case 3");
    }

    @BeforeMethod
    public void beforeEveryTestCase(){
        System.out.println("I am logging in before every test case");
    }
}
