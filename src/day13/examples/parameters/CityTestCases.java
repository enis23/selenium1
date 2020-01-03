package day13.examples.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CityTestCases {
    @Parameters({"url"})
    @Test
    public void openWebPage(String s) {
        System.out.println("Opening: " +  s);
    }

    @Test
    public void create() {
        System.out.println("City create test case");
    }

    @Test
    public void edit() {
        System.out.println("City edit test case");
    }

    @Test
    public void delete() {
        System.out.println("City delete test case");
    }

    @Parameters({"login", "password"})
    @Test
    public void login(String username, String password) {
        System.out.println("Login in, using login: " +  username + " and password:" + password);
    }
}
