package day9.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SimpleFormSolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://ultimateqa.com/filling-out-forms/" );

        driver.findElement( By.id( "et_pb_contact_name_0" ) ).sendKeys( generateRandomWordOfLength( 10 ) );
        driver.findElement( By.id( "et_pb_contact_message_0" ) ).sendKeys( generateRandomWordsOfLength( 10 ) );
        driver.findElement( By.cssSelector( ".et_pb_column_0 button" ) ).click();

        WebDriverWait wait = new WebDriverWait( driver, 15 );
        String testString = "Form filled out successfully";
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[contains(text(), '" + testString + "')]" ) ) );
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, text was not found in 15 seconds!" );
        }

    }

    public static String generateRandomWordOfLength(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            sb.append( candidateChars.charAt( random.nextInt( candidateChars
                    .length() ) ) );
        }
        return sb.toString();
    }

    public static String generateRandomWordsOfLength(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            sb.append( generateRandomWordOfLength( random.nextInt( 10 ) ) + " " );
        }
        return sb.toString();
    }


}
