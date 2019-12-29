package day9.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpFormSubmissionParsingSolution {
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        String path = "file:///" + System.getProperty( "user.dir" ) + "/src/day9/homework/homework1/SignUpFormSolution.html";
        driver.get( path );
        driver.findElement( By.name( "username" ) ).sendKeys( "name" );
        driver.findElement( By.name( "password" ) ).sendKeys( "password" );
        driver.findElement( By.name( "password_repeat" ) ).sendKeys( "password" );
        driver.findElement( By.name( "address" ) ).sendKeys( "7514 Riverview Rd.\n" + "Sheboygan, WI 53081" );
        driver.findElement( By.cssSelector( "input[type='radio'][value='male']" ) ).click();
        Select plan = new Select( driver.findElement( By.name( "plan" ) ) );
        plan.selectByIndex( plan.getOptions().size() - 1 ); //selects last option
        driver.findElement( By.name( "agreement" ) ).click();
        driver.findElement( By.id( "submit" ) ).click();
        String currentUrl = driver.getCurrentUrl();
        Map<String, String> queryMap = getQueryMap( currentUrl );
        for(String key : queryMap.keySet()) {
            System.out.println( key + " = " + queryMap.get( key ) );
        }
//        driver.quit();
    }
    //SignUpForm.html?username=name&password=password&password_repeat=password&address=7514+Riverview+Rd.%0D%0ASheboygan%2C+WI+53081&sex=male&plan=enterprise&agreement=on&x=100&y=24
    public static Map<String, String> getQueryMap(String query) {
        String onlyParams = query.substring( query.indexOf( "?" ) + 1 );
        String[] params = onlyParams.split( "&" );
        Map<String, String> map = new HashMap<String, String>();
        for(String param : params) {
            String key = param.split( "=" )[0];
            String value = param.split( "=" )[1];
            map.put( key, value );
        }
        return map;
    }
}
