package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindByAttributes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/input-form-demo.html" );
        // css selector can search by exact attribute
        List<WebElement> cssExactElements = driver.findElements( By.cssSelector( "[class='col-md-4']" ) );
        for(WebElement e : cssExactElements) {
            System.out.print(e.getTagName() + ", ");
        }
        System.out.println();
        System.out.println("Found: " + cssExactElements.size());
        System.out.println("-----------------------------------------------");

        // css selector can search attribute by contains
        List<WebElement> cssContainsElements = driver.findElements( By.cssSelector( "[class*='col-md-4']" ) );
        for(WebElement e : cssContainsElements) {
            System.out.print(e.getTagName() + ", ");
        }
        System.out.println();
        System.out.println("Found: " + cssContainsElements.size());
        System.out.println("-----------------------------------------------");

        // css selector can search attribute by startsWith
        List<WebElement> cssStartsWithElements = driver.findElements( By.cssSelector( "[class^='col-md-4']" ) );
        for(WebElement e : cssStartsWithElements) {
            System.out.print(e.getTagName() + ", ");
        }
        System.out.println();
        System.out.println("Found: " + cssStartsWithElements.size());
        System.out.println("-----------------------------------------------");

        // css selector can search attribute by endsWith
        List<WebElement> cssEndsWithElements = driver.findElements( By.cssSelector( "[class$='col-md-4']" ) );
        for(WebElement e : cssEndsWithElements) {
            System.out.print(e.getTagName() + ", ");
        }
        System.out.println("Found: " + cssEndsWithElements.size());

        driver.quit();
    }
}
