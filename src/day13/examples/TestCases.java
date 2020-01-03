package day13.examples;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCases {

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
}
