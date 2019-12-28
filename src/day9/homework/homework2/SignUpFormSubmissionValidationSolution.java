package day9.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SignUpFormSubmissionValidationSolution {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setProperty( "webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        String path = "file:///" + System.getProperty( "user.dir" ) + "/src/day9/homework/homework1/SignUpFormSolution.html";
        driver.get( path );

        Map<String, String> expectedValuesMap = initializeValues();
        fillTheForm( driver, expectedValuesMap );
        driver.findElement( By.id( "submit" ) ).click();
        Map<String, String> actualValuesMap = getParametersMap( driver.getCurrentUrl() );

        // Validate
        validate( expectedValuesMap, actualValuesMap );
        driver.quit();
    }

    private static void validate(Map<String, String> expectedValuesMap, Map<String, String> actualValuesMap) {
        boolean success = true;
        for(String key : expectedValuesMap.keySet()) {
            String expectedValue = expectedValuesMap.get( key ).replaceAll( "\\s+", "" );
            String actualValue = actualValuesMap.get( key ).replaceAll( "\\s+", "" );
            if(!expectedValue.equals( actualValue )) {
                success = false;
                System.out.println( "Key: " + key + " does not match: " + expectedValue + ", but should be:" + actualValue );
            }
        }
        System.out.println( success ? "Success!" : "Failure!" );
    }

    private static Map<String, String> initializeValues() {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put( "username", "Daulet" );
        valueMap.put( "password", "mySecretPassword" );
        valueMap.put( "password_repeat", "password" );
        valueMap.put( "address", "7514 Riverview Rd.\n" + "Sheboygan, WI 53081" );
        valueMap.put( "sex", "male" );
        valueMap.put( "plan", "enterprise" );
        valueMap.put( "agreement", "on" ); //this should always be on
        return valueMap;
    }

    private static void fillTheForm(WebDriver driver, Map<String, String> valueMap) {
        driver.findElement( By.name( "username" ) ).sendKeys( valueMap.get( "username" ) );
        driver.findElement( By.name( "password" ) ).sendKeys( valueMap.get( "password" ) );
        driver.findElement( By.name( "password_repeat" ) ).sendKeys( valueMap.get( "password_repeat" ) );
        driver.findElement( By.name( "address" ) ).sendKeys( valueMap.get( "address" ) );
        driver.findElement( By.cssSelector( "input[type='radio'][value='" + valueMap.get( "sex" ) + "']" ) ).click();
        Select planSelection = new Select( driver.findElement( By.name( "plan" ) ) );
        planSelection.selectByValue( valueMap.get( "plan" ) );
        if(valueMap.get( "agreement" ).equals( "on" )) {
            driver.findElement( By.name( "agreement" ) ).click();
        }
    }

    public static Map<String, String> getParametersMap(String query) throws UnsupportedEncodingException {
        String onlyParams = query.substring( query.indexOf( "?" ) + 1 );
        String[] params = onlyParams.split( "&" );
        Map<String, String> map = new HashMap<String, String>();
        for(String param : params) {
            String name = param.split( "=" )[0];
            String value = param.split( "=" )[1];
            String decodedValue = URLDecoder.decode( value, StandardCharsets.UTF_8.toString() );
            map.put( name, decodedValue );
        }
        return map;
    }
}
