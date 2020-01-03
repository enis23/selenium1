package day13.examples.tests.beforeTest;

import org.testng.annotations.BeforeTest;

public class BeforeWholeTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before running test");
    }
}
