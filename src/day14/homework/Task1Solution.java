package day14.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Task1Solution {

    private WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
    }

    @AfterClass
    public void quit() {
       driver.quit();
    }

    @Parameters({"number"})
    @Test
    public void clickAndValidateButtons(String numberOfTimeToClick) {
        int num = Integer.parseInt( numberOfTimeToClick );
        driver.get( "http://the-internet.herokuapp.com/add_remove_elements/" );

        WebElement btn = driver.findElement( By.xpath( "//*[@onclick='addElement()']" ) );
        for(int i = 0; i < num; i++) {
            btn.click();
        }
        List<WebElement> list = driver.findElements( By.className( "added-manually" ) );
        Assert.assertEquals( list.size(), num );
    }
}
