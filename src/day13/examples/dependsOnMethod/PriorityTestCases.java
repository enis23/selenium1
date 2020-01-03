package day13.examples.dependsOnMethod;

import org.testng.annotations.Test;

public class PriorityTestCases {
    @Test(priority = 2)
    public void create() {
        System.out.println("City create test case");
    }

    @Test(priority = 3)
    public void edit() {
        System.out.println("City edit test case");
    }

    @Test(priority = 4)
    public void delete() {
        System.out.println("City delete test case");
    }

    @Test(priority = 1)
    public void login() {
        System.out.println("Login");
    }

    @Test
    public void zeroPriority(){
        System.out.println("this is zero priority!");
    }
}
