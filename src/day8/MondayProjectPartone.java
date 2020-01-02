package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class MondayProjectPartone {

    public static void main(String[] args) throws InterruptedException {

    System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );

    WebDriver driver = new ChromeDriver();

    driver.get( "https://www.phptravels.net/en" );

    MondayProjectPartone m1 = new MondayProjectPartone();

    driver.manage().window().maximize();

    driver.findElement( By.xpath( "//a[@id='dropdownLangauge']" ) ).click();

    int size =  driver.findElements( By.xpath( "//a[@class='dropdown-item']" ) ).size();

    for(int i = 0 ; i < size ; i++){

        List<WebElement> languageOptions = driver.findElements( By.xpath( "//a[@class='dropdown-item']" ) );

        String myLanguage = languageOptions.get( i ).getText();

        languageOptions.get( i ).click();

        Thread.sleep( 2000 );

        String myURl = driver.getCurrentUrl();

        driver.findElement( By.xpath( "//a[@id='dropdownLangauge']" ) ).click();

        m1.checkUrl(myURl ,  myLanguage );

    }

        System.out.println("done");

    }


    public void checkUrl(String url , String language){

        if(language.equalsIgnoreCase( "ruSsian" )){

            Assert.assertTrue( url.contains( "/ru" ) );

        }else if(language.equalsIgnoreCase( "Farsi" )){
            Assert.assertTrue( url.contains( "/fa" ) );
        }
        else if(language.equalsIgnoreCase("Vietnamese")){
        Assert.assertTrue(url.contains("vi"));
        }
        else if(language.equalsIgnoreCase("French")){
        Assert.assertTrue(url.contains("fr"));
        }
        else if(language.equalsIgnoreCase("Turkish")){
        Assert.assertTrue(url.contains("tr"));
        }
        else if(language.equalsIgnoreCase("Arabic")){
        Assert.assertTrue(url.contains("ar"));
        }
        else if(language.equalsIgnoreCase("Spanish")){
        Assert.assertTrue(url.contains("es"));
        }
        else if(language.equalsIgnoreCase("English")) {
            Assert.assertTrue( url.contains( "en" ) );
        }
    }


}

/*
*   stale element exception is element was in the website but not in the website any more
*       or website is refreshed
 */