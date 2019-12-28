package day10.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SignUpFormSolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        String path = "file:///" + System.getProperty( "user.dir" ) + "/src/day10/homework/homework1/SignUpFormSolution.html";
        driver.get( path );
        driver.findElement( By.name( "username" ) ).sendKeys( "name" );
        driver.findElement( By.name( "password" ) ).sendKeys( "password" );
        driver.findElement( By.name( "password_repeat" ) ).sendKeys( "password" );
        driver.findElement( By.name( "address" ) ).sendKeys( "7514 Riverview Rd.\n" + "Sheboygan, WI 53081" );
        driver.findElement( By.cssSelector( "input[type='radio'][value='male']" ) ).click();
        Select plan = new Select( driver.findElement( By.name( "plan" ) ) );
        plan.selectByIndex( plan.getOptions().size() - 1 ); //selects last option
        driver.findElement( By.name( "agreement" ) ).click();
//        driver.quit();
    }
}
