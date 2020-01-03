package day13.examples.suite.afterWholeSuite;

import org.testng.annotations.AfterSuite;

public class AfterWholeSuite {
    @AfterSuite
    public void afterSuite(){
        System.out.println("Running after the whole suite");
    }
}
