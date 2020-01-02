package day13.examples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AfterEveryMethod {

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

    @AfterMethod
    public void afterEveryTestCase(){
        System.out.println("Some cleanup work after every test case");
    }
}
