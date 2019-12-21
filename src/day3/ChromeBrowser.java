package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "file:///C:\\Users\\k-eni\\IdeaProjects\\selenium1\\src\\day3\\resources\\form.html" );
        WebElement text = driver.findElement( By.name( "text" ) );
        text.sendKeys( "This is my text" );
        WebElement password = driver.findElement( By.name( "password" ) );
        password.sendKeys( "Password" );
        WebElement textarea = driver.findElement( By.name( "textarea" ) );
        textarea.sendKeys( "Some text Area words" );
        WebElement checkbox = driver.findElement( By.name( "checkbox" ) );
        checkbox.click();
        List<WebElement> radio = driver.findElements( By.name( "radio" ) );
        WebElement secondElementOfRadio = radio.get( 1 );// [0, 1, 2].click
        secondElementOfRadio.click();

        WebElement select = driver.findElement( By.name( "select" ) );
        // Select for dropdown
        Select dropdown = new Select( select );
//        dropdown.selectByIndex( 1 );
        List<WebElement> options = dropdown.getOptions();
        for(WebElement element : options) {
            if(element.getText().equals( "option 4" ))
                dropdown.selectByVisibleText( "option 4" );
        }

        String value1 = text.getAttribute( "value" );
        String value2 = password.getAttribute( "value" );
        String value3 = textarea.getAttribute( "value" );
        String value4 = checkbox.getAttribute( "value" );
        String value5 = secondElementOfRadio.getAttribute( "value" );
        String value6 = select.getAttribute( "value" );
        System.out.println( value1 );
        System.out.println( value2 );
        System.out.println( value3 );
        System.out.println( value4 );
        System.out.println( value5 );
        System.out.println( value6 );

        WebElement submitButton = driver.findElement( By.id( "submit" ) );
        submitButton.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println( currentUrl );

// close the drive and associated windows
        driver.quit();
    }
}
