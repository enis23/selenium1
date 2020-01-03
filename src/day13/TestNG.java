package day13;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {
    @Test
    public void login(){
        Assert.fail("First Test FAILED");
        System.out.println("First test!");
    }

    @Test
    public void createCity(){

    }

    @Test
    public void updateCity(){

    }
}
