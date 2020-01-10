package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class day3SimpleFormTask2SolutionTestNg {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        this.driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-first-form-demo.html" );

    }

    @BeforeMethod
    public void clearTextBoxes() {
        driver.findElement( By.id( "sum1" ) ).clear();
        driver.findElement( By.id( "sum2" ) ).clear();
    }

    @Test(dataProvider = "integerProvider")
    public void main(Integer number1, Integer number2) {
        driver.findElement( By.id( "sum1" ) ).sendKeys( number1.toString() );
        driver.findElement( By.id( "sum2" ) ).sendKeys( number2.toString() );

        driver.findElement( By.cssSelector( "#gettotal > button" ) ).click();

        String text = driver.findElement( By.id( "displayvalue" ) ).getText();

        String expected = String.valueOf( number1 + number2 );
        Assert.assertEquals( text, expected );

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{
                {100, 202},
                {102, 212},
                {101, 232},
                {104, 232},
                {5, 2222},
                {10, 22},
                {133, 22},
                {112, 22},
                {102, 322}
        };
    }
}
