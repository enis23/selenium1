package day10.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementToBeEnabledSolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/dynamic_controls" );

        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.findElement( By.cssSelector( "#input-example input[type='text'][disabled]" ) ); //check the element is present

        driver.findElement( By.xpath( "//button[contains(text(), 'Enable')]" ) ).click();

        try {
            wait.until( ExpectedConditions.invisibilityOfElementLocated( By.cssSelector( "#input-example input[type='text'][disabled]")) );
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, textInput was not enabled in 5 seconds!" );
        }

        try {
            WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//p[@id='message']" ) ) );
            System.out.println( message.getText().equals( "It's enabled!" ) ? "Success!" : "Failure");
        } catch(TimeoutException e) {
            System.out.println( "Failure, message was not 'It's enabled!' in 5 seconds!" );
        }

        driver.findElement( By.xpath( "//button[contains(text(), 'Disable')]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "#input-example input[type='text'][disabled]")));
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, textInput was not disabled in 5 seconds!" );
        }

        try {
            WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//p[@id='message']" ) ) );
            System.out.println( message.getText().equals( "It's disabled!" ) ? "Success!" : "Failure");
        } catch(TimeoutException e) {
            System.out.println( "Failure, message was not 'It's disabled!' in 5 seconds!" );
        }

        driver.quit();
    }
}
