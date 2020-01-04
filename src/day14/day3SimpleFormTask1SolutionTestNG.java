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

public class day3SimpleFormTask1SolutionTestNG {

    private WebDriver driver;

    @BeforeClass
    public void main() {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-first-form-demo.html" );
    }

    @Test
    public void test() {
        String myMessage = "Test string!";
        driver.findElement( By.id( "user-message" ) ).sendKeys( myMessage );
        driver.findElement( By.cssSelector( "#get-input > button" ) ).click();
        String text = driver.findElement( By.id( "display" ) ).getText();
        Assert.assertEquals( text, myMessage );
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
