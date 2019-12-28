package day9.homework.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/login" );

        String username = driver.findElement( By.xpath("//em[1]") ).getText();
        String password = driver.findElement( By.xpath("//em[2]") ).getText();

        driver.findElement( By.xpath( "//input[@id='username']" ) ).sendKeys( username );
        driver.findElement( By.xpath( "//input[@id='password']" ) ).sendKeys( password );

        driver.findElement( By.xpath( "//button[@type='submit']//*[contains(text(), 'Login')]" ) ).click();
        validateFlashText( driver, "You logged into a secure area!" );

        driver.findElement( By.xpath( "//*[contains(text(), 'Logout')]" ) ).click();
        validateFlashText( driver, "You logged out of the secure area!" );

        driver.quit();
    }

    private static void validateFlashText(WebDriver driver, String testText) {
        String flashText = driver.findElement( By.xpath( "//div[@id='flash']" ) ).getText();
        String xButton = driver.findElement( By.xpath( "//div[@id='flash']/a" ) ).getText();
        String actualText = flashText.replaceAll( xButton, "" ).trim();
        System.out.println(actualText.equals( testText ) ? "Success!": "Failure!");
    }
}
