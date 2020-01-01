package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Practice {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );

        driver.get( "https://test-basqar.mersys.io" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

        // to select "Setup"
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1)" ) ).click();
        // to select "Parameters"
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1)" ) ).click();
        // to select "Nationalities"
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1) > .children > :nth-child(4)" ) ).click();

        // Click on the plus button
        driver.findElement( By.cssSelector( "[data-icon='plus']" ) ).click();
    }
}
