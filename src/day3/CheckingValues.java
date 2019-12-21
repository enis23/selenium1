package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.HashMap;
import java.util.Map;

public class CheckingValues {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///D:/Project/seleniumWorking/src/day3/resources/form.html");

        Map<String, String> testValues = new HashMap<>();
        testValues.put("h1", "#0000ff");
        testValues.put("h2", "#ff0000");
        testValues.put("h3", "#00ff00");
        for (String key : testValues.keySet()) {
            checkElementColorByName(driver, key, testValues.get(key));
        }
        driver.quit();
    }

    public static void checkElementColorByName(WebDriver driver, String myTag, String testColor) {
        WebElement h1 = driver.findElement(By.tagName(myTag));
        String h1Color = h1.getCssValue("color");
        System.out.println(h1Color);
        String hex = Color.fromString(h1Color).asHex();
        System.out.println(hex);
        if (hex.equals(testColor)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}