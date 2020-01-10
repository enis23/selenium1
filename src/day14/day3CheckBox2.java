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

public class day3CheckBox2 {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Multiple Checkbox and check the button message
    // When you check all the checkboxes, button message will change to 'Uncheck All'
    // When you uncheck at least one checkbox, button message will change to 'Check All'
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test
    public void firstTestCase() {
        List<WebElement> elements = driver.findElements( By.className( "cb1-element" ) );
        for(WebElement element : elements) {
            element.click();
        }
        String actualButtonText = driver.findElement( By.id( "check1" ) ).getAttribute( "value" );
        Assert.assertEquals( actualButtonText, "Uncheck All" );
    }

    @Test
    public void secondTestCase(){
        List<WebElement> elements = driver.findElements( By.cssSelector( ".cb1-element:not(:checked)" ) ) ;
        for(WebElement element : elements) {
            element.click();
        }
        driver.findElement( By.className( "cb1-element" ) ).click();
        String actualButtonText = driver.findElement( By.id( "check1" ) ).getAttribute( "value" );
        Assert.assertEquals( actualButtonText, "Check All" );
    }

}
