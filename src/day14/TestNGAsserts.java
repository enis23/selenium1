package day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAsserts {
    @Test
    public void assertEqualsNoOrder(){
        String[] actual = {"", "string", ""};
        String[] expected = {"string", ""};
        Assert.assertEqualsNoOrder( actual, expected, "Arrays are not equal!" );
    }

    @Test
    public void assertNotEquals(){
        String[] actual = {"string", ""};
        String[] expected = {"string", ""};
        Assert.assertNotEquals( actual, expected, "Arrays are equal! They should not be!" );
    }
    @Test
    public void assertNotEqualsDoubles(){
        double actual = 3.1;
        double expected = 3.5;
        Assert.assertNotEquals( actual, expected, "Doubles are equal! They should not be!" );
    }

    @Test
    public void assertEqualsDoubles(){
        Object actual = new Object();
        Assert.assertNotNull( actual, "Object is null! They should not be!" );
    }
    @Test
    public void assertNull(){
        Object actual = someFunctionThatReturnsNullInSpecialCases();
        Assert.assertNull( actual, "Object is not null! They should be!" );
    }

    private Object someFunctionThatReturnsNullInSpecialCases() {
        return null;
    }

    @Test
    public void assertSame(){
        Object actual = new Object();
        Object expected = actual;
        Assert.assertSame( actual, expected );  // it's going to compare object references
    }
    @Test
    public void assertNotSame(){
        Object actual = new Object();
        Object expected = new Object();
        Assert.assertNotSame( actual, expected );  // it's going to compare object references
    }
    @Test
    public void assertTrue(){
        boolean actual = true;
        Assert.assertTrue( actual );  //
    }


    @Test
    public void assertFalse(){
        boolean actual = false;
        Assert.assertFalse( actual );  //
    }

    @Test
    public void assertTrueHowNotToUse(){
        double actual =  1.1;
        int expected = 1;
        Assert.assertTrue( actual == expected );  //
    }
    @Test
    public void assertEqualsHowToUse(){
        double actual =  1;
        int expected = 1;
        Assert.assertEquals( actual,  expected );  //
    }



    @Test
    public void login(){
        Assert.fail("First Test FAILED");
        System.out.println("First test!");
    }

    @Test
    public void createCity(){
        double i = 3.1;
        double l = 3.5;

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals( i, l );
        softAssert.assertEquals( i, l );
        softAssert.assertEquals( i, l );

        softAssert.assertAll(); //Assert all should be last line of test
    }

    @Test
    public void updateCity(){

        Assert.assertEquals( "\"testNG\"", "\"testNG\"" );
    }
}
