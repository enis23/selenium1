package day9.homework.homework4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class WaitForElementToBeEnabledWithErrorSolution {
    public static void main(String[] args) throws IOException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/dynamic_controls" );

        WebDriverWait wait = new WebDriverWait( driver, 2 );
        driver.findElement( By.cssSelector( "#input-example input[type='text']" ) ); //check the element is present

        driver.findElement( By.xpath( "//button[contains(text(), 'Enable')]" ) ).click();

        try {
            wait.until( ExpectedConditions.invisibilityOfElementLocated( By.cssSelector( "#input-example input[type='text'][disabled]")) );
            System.out.println( "Success!" );
        } catch(TimeoutException e) {
            System.out.println( "Failure, textInput was not enabled in 5 seconds!" );
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File DestFile=new File(System.getProperty( "user.dir" ) + "/src/day9/homework/homework4/enabledFailed.png");
            FileUtils.copyFile(file, DestFile);
        }

        driver.quit();
    }
}
