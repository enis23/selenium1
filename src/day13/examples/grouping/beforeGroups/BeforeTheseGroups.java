package day13.examples.grouping.beforeGroups;

import org.testng.annotations.BeforeGroups;

public class BeforeTheseGroups {
    @BeforeGroups("regression")
    public void beforeRegressionGroup(){
        System.out.println("Before Regression Group");
    }

    @BeforeGroups("functional")
    public void beforeFunctionalGroup(){
        System.out.println("Before Functional Group");
    }
}
