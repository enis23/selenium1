package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Day4Homework1SolutionTestNG {
    private List<WebElement> links;
    private WebDriver driver;

    // go to URL: https://www.seleniumeasy.com/test/
    // click on each link of class="board-inner"
    // and validate that class="tab-content" has
    // correct text for "h3" tag and adjacent "p" tag in active div
    // after you click associated link above

    // there should be at least 5 test of "h3" tag and adjacent "p" tag

    @DataProvider
    public Object[][] valuesProvider() {
        return new Object[][]{
                {0, "WELCOME TO SELENIUM EASY DEMO", "We have listed most of the components that are used by developers to build web applications."},
                {1,"BASIC EXAMPLES TO START WITH SELENIUM", "Assuming you have a basic understanding of HTML and CSS."},
                {2,"INTERMEDIATE EXAMPLES WITH MOST POPULAR COMPONENTS", "Hoppe you had Great fun automating basic demo components."},
                {3, "ADVANCED EXAMPLES WITH COMPONENTS", "  These are not much difficult to Automate. Give a try to automate below components "},
                {4,"THANKS FOR STAYING TUNED! WE ARE DONE", "\n" +
                        "                                  Now focus on building automation framework from scratch using Selenium WebDriver.\n" +
                        "                                "},
        };
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/" );
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test(dataProvider = "valuesProvider")
    private void validate(int i, String s1, String s2) throws InterruptedException {
        links = driver.findElements( By.cssSelector( ".board-inner a" ) );
        links.get( i ).click();
        Thread.sleep( 1000 );

        WebElement activeH3Tag = driver.findElement( By.cssSelector( ".tab-content .active h3" ) );
        WebElement activeFirstPTag = driver.findElement( By.cssSelector( ".tab-content .active p" ) );

        String actualH3 = activeH3Tag.getText().trim();
        String expectedH3 = s1.trim();
        Assert.assertEquals( actualH3, expectedH3 );

        String actualP = activeFirstPTag.getText().trim();
        String expectedP = s2.trim();
        Assert.assertEquals( actualP, expectedP );
    }
}
