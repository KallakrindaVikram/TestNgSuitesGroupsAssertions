package org.epam.parameters;

import org.epam.Biscuit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BiscuitParameterTest {

    private Biscuit biscuit;

    @BeforeMethod
    public void setUp() {
        biscuit = new Biscuit("Good Day", 20);
    }

    @AfterMethod
    public void tearDown() {
        biscuit = null;
    }

    @Test
    @Parameters("count")
    public void testTakeBiscuits(int count){
        int balance = biscuit.getBiscuitCount()-count;
        if(balance<0) throw new IllegalArgumentException("Cant take more than available biscuits from jar");
        biscuit.takeBiscuit(count);
        Assert.assertEquals(biscuit.getBiscuitCount(),balance);
    }

    @Test
    @Parameters({"count"})
    public void testPutBiscuits(int count){
        int balance = biscuit.getBiscuitCount()+count;
        if(balance>Biscuit.JAR_CAPACITY) throw new IllegalArgumentException("Jar limit will exceed");
        biscuit.putBiscuit(count);
        Assert.assertEquals(biscuit.getBiscuitCount(),balance);
    }

}
