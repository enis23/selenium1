package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitVisibilityExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "/Users/technostudy/Selenium/ChromeDriver/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://jsfiddle.net/daulet2030/eLy027xg/" );
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.switchTo().frame("result");
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#test1")));
        System.out.println(webElement.getTagName());
//        driver.quit();
    }
}
