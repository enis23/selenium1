package day13.examples.dependsOnMethod;

import org.testng.annotations.Test;

public class CityTestCases {

    @Test
    public void create() {
        System.out.println("City create test case");
    }

    @Test(dependsOnMethods = {"login"})
    public void edit() {
        System.out.println("City edit test case");
    }

    @Test(dependsOnMethods = {"login", "create"})
    public void delete() {
        System.out.println("City delete test case");
    }

    @Test
    public void login() {
        System.out.println("Login");
    }
}
