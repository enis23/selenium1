package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChromeBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:\\Users\\k-eni\\IdeaProjects\\selenium1\\src\\day3\\resources\\form.html");
        WebElement text = driver.findElement(By.name("text"));
        text.sendKeys("This is my text");
        WebElement webElement = driver.findElement(By.name("password"));
        webElement.sendKeys("Password");
        WebElement textarea = driver.findElement(By.name("textarea"));
        textarea.sendKeys("Some text Area words");
        WebElement checkbox = driver.findElement(By.name("checkbox"));
        checkbox.click();
        List<WebElement> radio = driver.findElements(By.name("radio"));
        WebElement secondElementOfRadio = radio.get(1);// [0, 1, 2]
        secondElementOfRadio.click();
        WebElement select = driver.findElement(By.name("select"));
        Select dropdown = new Select(select);
        dropdown.selectByIndex(3);
        System.out.println(text.getAttribute("value"));
        System.out.println(webElement.getAttribute("value"));
        System.out.println(textarea.getAttribute("value"));
        System.out.println(checkbox.getAttribute("value"));
        System.out.println(select.getAttribute("value"));
    }
}
        //close the driver and associated windows
      //  driver.quit();
