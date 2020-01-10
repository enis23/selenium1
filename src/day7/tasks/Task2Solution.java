package day7.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2Solution {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/add_remove_elements/" );
        createButtons(driver, 70);
        deleteButtonsAndValidate(driver, 50);

        driver.quit();
    }

    private static void createButtons(WebDriver driver, int numberOfButtonsToAdd) {
        WebElement btn = driver.findElement( By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < numberOfButtonsToAdd; i++) {
            btn.click();
        }
    }

    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement> elements = driver.findElements( By.cssSelector( "[onclick='deleteElement()']" ) );
        int sizeBeforeDeleting = elements.size();

        List<WebElement> buttonsToDelete = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int counter = 0;
        for(WebElement webElement : buttonsToDelete) {
            counter++;
            if(counter > number){
                break;
            }
            webElement.click();
        }

        List<WebElement> elementsAfter = driver.findElements( By.cssSelector( "[onclick='deleteElement()']" ) );
        int sizeAfterDeleting = elementsAfter.size();

        if((sizeBeforeDeleting -  number) == sizeAfterDeleting ) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}
