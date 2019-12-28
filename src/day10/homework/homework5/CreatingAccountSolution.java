package day10.homework.homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CreatingAccountSolution {
    public static void main(String[] args) {

        // Captcha on this website is un-avoidable, so you will have to solve it by hand to allow script to continue
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://courses.ultimateqa.com/users/sign_up" );
        driver.manage().window().maximize();

        String firstName = generateRandomNameOfLength( 3, 5 );
        String lastName = generateRandomNameOfLength( 3, 10 );
        String email = generateRandomWordOfLength( 4, 10 ) + "@" + generateRandomWordOfLength( 2, 5 ) + "." + generateRandomWordOfLength( 2, 3 );
        String password = generateRandomWordOfLength( 3, 4 ) + generateRandomNameOfLength( 5, 10 );

        driver.findElement( By.id( "user[first_name]" ) ).sendKeys( firstName );
        driver.findElement( By.id( "user[last_name]" ) ).sendKeys( lastName );
        driver.findElement( By.id( "user[email]" ) ).sendKeys( email );
        driver.findElement( By.id( "user[password]" ) ).sendKeys( password );
        driver.findElement( By.id( "user[terms]" ) ).click();
        driver.findElement( By.cssSelector( "input[value='Sign up']" ) ).click();

        WebDriverWait wait = new WebDriverWait( driver, 500 );
        wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "a.dropdown__toggle-button" ) ) );

        driver.get( "https://courses.ultimateqa.com/account" );
        String actualFirstName = driver.findElement( By.id( "user[first_name]" ) ).getAttribute( "value" );
        String actualLastName = driver.findElement( By.id( "user[last_name]" ) ).getAttribute( "value" );
        String actualEmail = driver.findElement( By.id( "user[email]" ) ).getAttribute( "value" );

        System.out.println( firstName.equals( actualFirstName ) ? "Success!" : "Failure!" );
        System.out.println( lastName.equals( actualLastName ) ? "Success!" : "Failure!" );
        System.out.println( email.equals( actualEmail ) ? "Success!" : "Failure!" );

        WebElement dropdown = driver.findElement( By.cssSelector( "a.dropdown__toggle-button" ) );
        dropdown.click();

        WebElement signOutLink = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//a[contains(text(), 'Sign Out')]" ) ) );
        signOutLink.click();

        WebElement signInLink = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//a[contains(text(), 'Sign In')]" ) ) );
        signInLink.click();

        driver.findElement( By.id( "user[email]" ) ).sendKeys( email );
        driver.findElement( By.id( "user[password]" ) ).sendKeys( password );
        driver.findElement( By.cssSelector( "input[value='Sign in']" ) ).click();

        WebElement message = wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "p.message-text" ) ) );
        System.out.println( message.getText().equals( "Signed in successfully." ) ? "Signed in successfully." : "Failure!" );

    }

    public static String generateRandomNameOfLength(int from, int to) {
        String candidateCapitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < from + random.nextInt( to ); i++) {
            if(i == 0) {
                sb.append( candidateCapitalChars.charAt( random.nextInt( candidateCapitalChars
                        .length() ) ) );
            } else {
                sb.append( candidateChars.charAt( random.nextInt( candidateChars
                        .length() ) ) );
            }
        }
        return sb.toString();
    }

    public static String generateRandomWordOfLength(int from, int to) {
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < from + random.nextInt( to ); i++) {
            sb.append( candidateChars.charAt( random.nextInt( candidateChars
                    .length() ) ) );
        }
        return sb.toString();
    }
}
