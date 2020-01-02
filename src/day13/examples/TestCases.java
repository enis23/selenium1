package day13.examples;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCases {

    @Test
    public void TestCase1() {
        System.out.println("Testing test case 1");
    }

    @Ignore
    public void TestCase2() {
        System.out.println("Testing test case 2");
    }

    @Test(enabled = false)
    public void TestCase3() {
        System.out.println("Testing test case 3");
    }
}
