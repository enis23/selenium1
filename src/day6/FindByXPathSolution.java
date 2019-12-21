package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindByXPathSolution {
    // https://www.seleniumeasy.com/test/input-form-demo.html
    // fill in the form using xpath by attribute,
    // by contains(),
    // by index,
    // also by child
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/input-form-demo.html" );
        WebElement email = driver.findElement( By.xpath( "//*[@placeholder='E-Mail Address']" ) );
        email.sendKeys( "s.k.daulet@gmail.com" );

        // by contains
        List<WebElement> list1 = driver.findElements( By.xpath( "//*[contains(@name,'name')]" ) );
        for(WebElement element : list1) {
            element.sendKeys( "Name" );
        }

        // using index
        WebElement phone = driver.findElement( By.xpath( "//div[@class='form-group'][4]//input[@type='text']" ) );
        phone.sendKeys( "6545132468453135" );

        // using child
        WebElement address = driver.findElement( By.xpath( "//div[@class='form-group'][5]//child::input" ) );
        address.sendKeys( "My Address" );
        driver.quit();
    }
}
