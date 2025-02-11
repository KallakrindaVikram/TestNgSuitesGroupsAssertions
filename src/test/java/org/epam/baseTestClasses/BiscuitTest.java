package org.epam.baseTestClasses;

import org.epam.Biscuit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BiscuitTest {
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
    public void testTakeBiscuitNormal() {
        biscuit.takeBiscuit(5);
        Assert.assertEquals(biscuit.getBiscuitCount(), 15);
    }


    @Test
    public void testPutBiscuitNormal() {
        biscuit.putBiscuit(5);
        Assert.assertEquals(biscuit.getBiscuitCount(), 25);
    }

    @Test
    public void testPutBiscuitToFullJar() {
        biscuit.putBiscuit(10);
        Assert.assertEquals(biscuit.getBiscuitCount(), 30);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPutBiscuitOverflow() {
        biscuit.putBiscuit(15);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTakeMoreBiscuitsThanAvailable() {
        biscuit.takeBiscuit(35);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTakeBiscuitWhenNoneAvailable() {
        biscuit.takeBiscuit(20);
        biscuit.takeBiscuit(1);
        Assert.assertEquals(biscuit.getBiscuitCount(), 0);
    }

}