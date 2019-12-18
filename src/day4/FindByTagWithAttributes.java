package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindByTagWithAttributes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/input-form-demo.html" );
        List<WebElement> elements = driver.findElements( By.tagName( "input" ) );
        List<WebElement> cssElements = driver.findElements( By.cssSelector( "input[type='text']" ) );
        for(WebElement e : elements) {
            System.out.println(e.getAttribute( "outerHTML" ));
        }
        System.out.println("---------------------------------------");
        for(WebElement e : cssElements) {
            System.out.println(e.getAttribute( "outerHTML" ));
        }

        // css selector can be more specific
        driver.quit();
    }
}
