package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindByXPath {
    // https://www.seleniumeasy.com/test/input-form-demo.html
    // fill in the form using xpath by attribute,
    // by contains(),
    // by index,
    // also by child
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        WebElement email = driver.findElement(By.xpath("//*[@placeholder='E-mail Address']"));
        email.sendKeys("ekarabulut2334@gmail.com");

        List<WebElement> list1 = driver.findElements(By.xpath("//*[@contains(@name,'name')]"));
        for(WebElement element : list1) {
            element.sendKeys( "Name" );
        }


       // driver.quit();
    }
}