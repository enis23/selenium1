package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day3CheckBox1TestNG {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Single Checkbox and check the message bellow it
    WebDriver driver;
    @AfterClass
    public void quit(){
        driver.quit();
    }
    @BeforeClass
    public void prepareWebDriver(){
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );
    }

    @Test
    public void test(){
        driver.findElement( By.id( "isAgeSelected" ) ).click();
        String actualText = driver.findElement( By.id( "txtAge" ) ).getText();
        Assert.assertEquals( actualText, "Success - Check box is checked" );
    }

}
