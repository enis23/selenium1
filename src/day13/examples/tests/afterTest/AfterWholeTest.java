package day13.examples.tests.afterTest;


import org.testng.annotations.AfterTest;

public class AfterWholeTest {

    @AfterTest
    public void afterTest(){
        System.out.println("After running test");
    }
}
