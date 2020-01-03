package day13.examples.grouping;

import org.testng.annotations.Test;

public class NationalityTestCases {

    @Test(groups = {"functional"})
    public void TestCase1() {
        System.out.println("Nationality functional test case 1");
    }

    @Test(groups = {"smoke"})
    public void TestCase2() {
        System.out.println("Nationality smoke test case 2");
    }

    @Test(groups = {"functional"})
    public void TestCase3() {
        System.out.println("Nationality functional test case 3");
    }
}
