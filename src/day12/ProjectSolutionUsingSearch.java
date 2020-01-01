package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProjectSolutionUsingSearch {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://test-basqar.mersys.io" );
        driver.manage().window().maximize();
        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );

        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1)" ) ).click();
        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1)" ) ).click();
        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(4)" ) ).click();

        String nationality = generateRandomNameOfLength( 7, 10 );
        driver.findElement( By.cssSelector( "ms-add-button[tooltip=\"NATIONALITIES.TITLE.ADD\"]" ) ).click();
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).sendKeys( nationality );
        driver.findElement( By.cssSelector( "mat-dialog-actions button.save-button" ) ).click();

        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector( "div[aria-label=\"Nationality successfully created\"]" ) ) );
            System.out.println( nationality + " => Creation Success!" );
        } catch(Exception e) {
            System.out.println( nationality + " => Creation Failure!" );
        }

        WebElement nameSearch = driver.findElement( By.cssSelector( "ms-browse-search ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) );
        nameSearch.clear();
        for (int i=0; i < nationality.length(); i++) {
            nameSearch.sendKeys(nationality.charAt(i)+"");
        }
        driver.findElement( By.cssSelector( "ms-browse-search ms-search-button" ) ).click();
        wait.until( ExpectedConditions.numberOfElementsToBe( By.cssSelector( "tbody > tr" ), 1 ) );

        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-edit-button" ) ).click();
        String updatedNationality = nationality + "1";
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).clear();
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).sendKeys( updatedNationality );
        driver.findElement( By.cssSelector( "mat-dialog-actions button.save-button" ) ).click();
        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector( "div[aria-label=\"Nationality successfully updated\"]" ) ) );
            System.out.println( updatedNationality + " => Update Success!" );
        } catch(Exception e) {
            System.out.println( updatedNationality + " => Update Failure!" );
        }

        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();
        driver.findElement( By.cssSelector( "mat-dialog-actions button.mat-accent" ) ).click();

        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector( "div[aria-label=\"Nationality successfully deleted\"]" ) ) );
            wait.until( ExpectedConditions.numberOfElementsToBe( By.cssSelector( "tbody > tr" ), 0 ) );
            System.out.println( updatedNationality + " => Delete Success!" );
        } catch(Exception e) {
            System.out.println( updatedNationality + " => Delete Failure!" );
        }

//        driver.quit();
    }

    public static String generateRandomNameOfLength(int from, int to) {
        String candidateCapitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < from + random.nextInt( to ); i++) {
            if(i == 0) {
                sb.append( candidateCapitalChars.charAt( random.nextInt( candidateCapitalChars
                        .length() ) ) );
            } else {
                sb.append( candidateChars.charAt( random.nextInt( candidateChars
                        .length() ) ) );
            }
        }
        return sb.toString();
    }
}
