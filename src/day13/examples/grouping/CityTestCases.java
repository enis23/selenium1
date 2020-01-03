package day13.examples.grouping;

import org.testng.annotations.Test;

public class CityTestCases {

    @Test(groups = {"smoke"})
    public void TestCase4() {
        System.out.println("City smoke test case 4");
    }

    @Test(groups = {"smoke", "regression"})
    public void TestCase5() {
        System.out.println("City smoke and regression test case 5");
    }

    @Test(groups = {"functional"})
    public void TestCase6() {
        System.out.println("City functional test case 6");
    }
}
