package day13.examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeThisClass {

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

    @BeforeClass
    public void someSetupBeforeClass(){
        System.out.println("Some setup before running all test cases inside this class");
    }
}
