package day13.examples.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CityTestCases {

    @Test
    public void create() {
        System.out.println("City create test case");
    }

    @Test
    public void edit() {
        Assert.fail("Failed to edit!");
        System.out.println("City edit test case");
    }

    @Test
    public void delete() {
        System.out.println("City delete test case");
    }
}
