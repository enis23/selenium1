package day4.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework1 {

    // go to URL: https://www.seleniumeasy.com/test/
    // click on each link of class="board-inner"
    // and validate that class="tab-content" has
    // correct text for "h3" tag and adjacent "p" tag in active div
    // after you click associated link above
        // h3 + p
    // there should be at least 5 test of "h3" tag and adjacent "p" tag
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/" );
        List<WebElement> links = driver.findElements( By.cssSelector( ".board-inner a" ) );

        String[] testStringForH3 = { "WELCOME TO SELENIUM EASY DEMO", "BASIC EXAMPLES TO START WITH SELENIUM", "INTERMEDIATE EXAMPLES WITH MOST POPULAR COMPONENTS", "ADVANCED EXAMPLES WITH COMPONENTS", "THANKS FOR STAYING TUNED! WE ARE DONE"};
        String[] testStringForP = { "We have listed most of the components that are used by developers to build web applications.", "Assuming you have a basic understanding of HTML and CSS.", "Hoppe you had Great fun automating basic demo components.", "  These are not much difficult to Automate. Give a try to automate below components ", "\n" +
                "                                  Now focus on building automation framework from scratch using Selenium WebDriver.\n" +
                "                                "};

        int counter = 0;
        for(WebElement link : links) {
            link.click();
            Thread.sleep( 1000 );
            WebElement h3Tag = driver.findElement( By.cssSelector( ".tab-content .active h3" ) );
            boolean h3Validation =  h3Tag.getText().equals( testStringForH3[counter].trim() );

            WebElement pTag = driver.findElement( By.cssSelector( ".tab-content .active h3 + p" ) );
            boolean pValidation =  pTag.getText().equals( testStringForP[counter].trim() );

            if(h3Validation && pValidation) {
                System.out.println("Success!");
            } else {
                System.out.println("Failure!");
            }

            counter++;

        }


    }
}
