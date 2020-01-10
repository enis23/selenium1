package day7;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TakeAScreenShotExample {
    public static void main(String[] args, Object FileUtils) throws InterruptedException, IOException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://jsfiddle.net/daulet2030/eLy027xg/" );
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.switchTo().frame("result");
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#test1")));
        System.out.println(webElement.getTagName());
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./test.png");
//        FileUtils.copyFile(file, DestFile);

//        driver.quit();
    }
}
