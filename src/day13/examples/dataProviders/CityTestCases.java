package day13.examples.dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CityTestCases {

    @Test(dataProvider = "cityProvider")
    public void create(String city, String country) {
        System.out.println("Creating city: "+city+" in country: "+country+" test case");
    }

    @Test(dataProvider = "cityProvider")
    public void edit(String city, String country) {
        System.out.println("Editing city: "+city+" in country: "+country+" test case");
    }

    @Test
    public void delete() {
        System.out.println("City delete test case");
    }

    @DataProvider
    public Object[][] cityProvider(){
        /* Object[rows][columns]
         * City     | Country
         * -------------------------
         * New York | USA
         * Almaty   | Kazakhstan
         * Istanbul | Turkey
         * -------------------------
         */
        Object[][] data = new Object[3][2];

        data[0][0] = "New York";
        data[0][1] = "USA";

        data[1][0] = "Almaty";
        data[1][1] = "Kazakhstan";

        data[2][0] = "Istanbul";
        data[2][1] = "Turkey";

        return data;
    }
}
