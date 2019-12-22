package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://ultimateqa.com/simple-html-elements-for-automation/" );
        WebElement div = driver.findElement( By.xpath( "//div[contains(@class, 'et_pb_blurb_6')]" ) );
        System.out.println(div.getText());
        driver.quit();
    }
}
