package day8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertClass {
    public static void main(String[] args) {


        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver();

        driver.get( "https://www.phptravels.net/en" );

        //asserts in selenium

        /*
        *   assert(hard assert)
        *       hard assert is if the condition does not match with the
        * assertion then it is stop executing
        *
        *   verify(soft assert)
        *       soft assert if the condition is not matching it will continue executing
         */

        String url = driver.getCurrentUrl();

        //assert True
        Assert.assertTrue(url.contains("en" ));

        System.out.println("This is after True Assert");

        Assert.assertFalse(url.contains("fr" ));

        System.out.println("This is after false Assert");

        Assert.assertEquals( "Techno","Techno" );

        System.out.println("This is after equals");
    }
}

