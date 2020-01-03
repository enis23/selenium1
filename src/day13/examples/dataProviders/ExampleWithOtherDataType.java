package day13.examples.dataProviders;

import day7.ImplicitWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleWithOtherDataType {
    @Test(dataProvider = "integerProvider")
    public void test(String cityName, Integer place, Double w){
        System.out.println("The city "+ cityName + " is in the " + place+ "! " + w);
    }

    @DataProvider
    public Object[][] integerProvider(){
     return new Object[][]   {
             {"New york", new Integer(1), new Double( 1.5 )},
             {"New york", new Integer(2), new Double( 1.5 )},
             {"New york", new Integer(3), new Double( 1.5 )},
             {"New york", new Integer(4), new Double( 1.5 )},
             {"New york", new Integer(5), new Double( 1.5 )},
             {"New york", new Integer(6), new Double( 1.5 )},
             {"New Jersey", new Integer( 2 ), new Double( 2.3 )}
     };
    }
}
