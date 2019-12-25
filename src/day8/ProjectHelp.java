package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProjectHelp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.phptravels.net/en" );
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( By.xpath( "//figure[@class='featured-image-grid-item with-highlight']" ) ) );
        List<WebElement> elements = driver.findElements( By.xpath( "//figure[@class='featured-image-grid-item with-highlight']" ) );

        int randomTourIndex =  new Random().nextInt(elements.size() - 1);
        WebElement randomTour = elements.get( randomTourIndex );
        randomTour.click();

        selectRandom( driver , "selectedAdults");
        selectRandom( driver , "selectedChild");
        selectRandom( driver , "selectedInfants");


//        driver.quit();
    }

    private static void selectRandom(WebDriver driver, String id) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( id ) ) );
        Select selection = new Select( driver.findElement( By.id( id ) ));
        int randomIndex = new Random( ).nextInt( selection.getOptions().size() - 1 );
        selection.selectByIndex( randomIndex );
    }
}
