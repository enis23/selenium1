package day9.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementVisibilitySolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/dynamic_controls" );

        WebDriverWait wait = new WebDriverWait( driver, 5 );
        WebElement checkBox = driver.findElement( By.cssSelector( "#checkbox-example input[type='checkbox']" ) );

        driver.findElement( By.xpath( "//button[contains(text(), 'Remove')]" ) ).click();

        try {
            wait.until( ExpectedConditions.invisibilityOf( checkBox ) );
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, checkBox was not invisible in 5 seconds!" );
        }

        try {
            WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//p[@id='message']" ) ) );
            System.out.println( message.getText().equals( "It's gone!" ) ? "Success!" : "Failure" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, message was not 'It's gone!' in 5 seconds!" );
        }

        driver.findElement( By.xpath( "//button[contains(text(), 'Add')]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "#checkbox-example input[type='checkbox']" ) ) );
//            wait.until( ExpectedConditions.visibilityOf(checkBox)); // this would become stale, because checkbox was removed from DOM
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, checkBox was not visible in 5 seconds!" );
        }

        try {
            WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//p[@id='message']" ) ) );
            System.out.println( message.getText().equals( "It's back!" ) ? "Success!" : "Failure" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, message was not 'It's back!' in 5 seconds!" );
        }

        driver.quit();
    }
}
