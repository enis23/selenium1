package day3.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox1 {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Single Checkbox and check the message bellow it
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }
}