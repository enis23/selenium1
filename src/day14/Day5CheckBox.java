package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class  Day5CheckBox {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Click on the button "Check All"
    // validate that all checkboxes are checked
    // using By.cssSelector( "input:checked" );
    WebDriver driver;

    @BeforeClass
    public void clickWebsite() {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );


    }

    @Test
    public void uncheckboxes() {
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );
        List<WebElement> uncheckedBoxes = driver.findElements( By.cssSelector( ".cb1-element:not(:checked)" ) );
        int sizeBefore = uncheckedBoxes.size();
        driver.findElement( By.id( "check1" ) ).click();
        List<WebElement> checkedBoxes = driver.findElements( By.cssSelector( ".cb1-element:checked" ) );
        int sizeAfter = checkedBoxes.size();
        Assert.assertEquals( sizeBefore, sizeAfter );


    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}


