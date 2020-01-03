package day13.examples.grouping.afterGroups;

import org.testng.annotations.AfterGroups;

public class AfterTheseGroups {
    @AfterGroups("regression")
    public void afterRegressionGroup(){
        System.out.println("After Regression Group");
    }

    @AfterGroups("functional")
    public void afterFunctionalGroup(){
        System.out.println("After Functional Group");
    }
}
