package day3simpleform.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Project1 {
    public static void main(String[] args) {
    System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
    WebDriver driver = new ChromeDriver();
    driver.get( "https://www.techlistic.com/p/selenium-practice-form.html");
     WebElement firstname = driver.findElement(By.name("firstname"));
     firstname.sendKeys("Enis");
    WebElement lastname = driver.findElement(By.name("lastname"));
    lastname.sendKeys("Karabulut");
    List<WebElement> gender = driver.findElements( By.name( "sex" ) );
    WebElement secondElementOfGender = gender.get( 0 );
    secondElementOfGender.click();
    List<WebElement>experience=driver.findElements(By.name("exp"));
    experience.get(3).click();
        WebElement Date = driver.findElement(By.id("datepicker"));
        Date.sendKeys("12/16/2019");
        WebElement element = driver.findElement(By.id("profession-0"));
        element.click();
        WebElement element1 = driver.findElement(By.id("profession-1"));
        element1.click();
        WebElement element2 = driver.findElement(By.id("tool-1"));
        element2.click();
        WebElement element3 = driver.findElement(By.id("tool-2"));
        element3.click();

        WebElement continents = driver.findElement(By.id("continents"));
        Select dropdown=new Select(continents);
        dropdown.selectByIndex(5);

        Select select = new Select(driver.findElement(By.id("selenium_commands")));
        List<WebElement> select31Options = select.getOptions();
        for (WebElement option : select31Options) {
            select.selectByVisibleText(option.getText());
        }

    }
}
