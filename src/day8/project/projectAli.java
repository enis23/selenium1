package day8.project;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class projectAli {
    private static Object comment;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.phptravels.net/en" );

        driver.findElement(By.id("dropdownLangauge")).click();
        driver.findElement(By.id("ru")).click();
        Thread.sleep(1000);
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url1.contains("ru" ));
        System.out.println("Russian language page is verify");

        driver.findElement(By.id("dropdownLangauge")).click();
        driver.findElement(By.id("en")).click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("en" ));
        System.out.println("English language page is verify");


        }
    }

