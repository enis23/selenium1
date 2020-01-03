package day13.examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AfterThisClass {

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

    @AfterClass
    public void cleanUpAfterClass(){
        System.out.println("Clean up after running all test cases inside this class");
    }
}
