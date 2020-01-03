package day13.examples.suite.beforeWholeSuite;

import org.testng.annotations.BeforeSuite;

public class BeforeWholeSuite {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Running before the whole suite");
    }
}
