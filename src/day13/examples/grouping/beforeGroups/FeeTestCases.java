package day13.examples.grouping.beforeGroups;

import org.testng.annotations.Test;

public class FeeTestCases {

    @Test(groups = {"regression"})
    public void TestCase1() {
        System.out.println("Fee regression test case 1");
    }

    @Test(groups = {"functional"})
    public void TestCase2() {
        System.out.println("Fee functional test case 2");
    }

    @Test(groups = {"smoke"})
    public void TestCase3() {
        System.out.println("Fee smoke test case 3");
    }
}
