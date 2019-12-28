package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/input-form-demo.html" );
        driver.manage().window().maximize();
        // implicitWait
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement( By.name( "first_name" ) ).sendKeys( "Techno" );
        driver.findElement( By.name( "last_name" ) ).sendKeys( "Study" );
        driver.findElement( By.name( "email" ) ).sendKeys( "technostudy19@gmail.com" );
        driver.findElement( By.name( "phone" ) ).sendKeys( "+15513021534" );
        driver.findElement( By.name( "address" ) ).sendKeys( "600 Getty Ave" );
        driver.findElement( By.name( "city" ) ).sendKeys( "Clifton" );
        Select stateSelect = new Select( driver.findElement( By.name( "state" ) ) );
        stateSelect.selectByIndex( 2 );
        driver.findElement( By.name( "zip" ) ).sendKeys( "07011" );
        driver.findElement( By.name( "website" ) ).sendKeys( "https://www.techno.study/" );

        // Scroll down
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript( "window.scrollTo(0, document.body.scrollHeight)" );

        driver.findElement( By.name( "hosting" ) ).click();
        driver.findElement( By.name( "comment" ) ).sendKeys( "Our vision is to revolutionize traditional boot-camp training by giving students the opportunity to try their new skills in on-going projects and start their job hunt with real experience" );
        driver.findElement( By.cssSelector( "button[type='submit']" ) ).click();
        driver.quit();

    }
}
