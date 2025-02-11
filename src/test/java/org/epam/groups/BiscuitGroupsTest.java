package org.epam.groups;

import org.epam.Biscuit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BiscuitGroupsTest {
    private Biscuit biscuit;

    @BeforeMethod(groups = {"put","take","exception"})//alwaysRun = true
    public void setUp() {
        biscuit = new Biscuit("Good Day", 20);
    }

    @AfterMethod(groups = {"put","take","exception"})
    public void tearDown() {
        biscuit = null;
    }

    @Test(groups = {"take"})
    public void testTakeBiscuitNormal() {
        biscuit.takeBiscuit(5);
        Assert.assertEquals(biscuit.getBiscuitCount(), 15);
    }


    @Test(groups = {"put"})
    public void testPutBiscuitNormal() {
        biscuit.putBiscuit(5);
        Assert.assertEquals(biscuit.getBiscuitCount(), 25);
    }

    @Test(groups = {"put"})
    public void testPutBiscuitToFullJar() {
        biscuit.putBiscuit(10);
        Assert.assertEquals(biscuit.getBiscuitCount(), 30);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,groups = {"put","exception"})
    public void testPutBiscuitOverflow() {
        biscuit.putBiscuit(15);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,groups = {"take","exception"})
    public void testTakeMoreBiscuitsThanAvailable() {
        biscuit.takeBiscuit(35);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,groups = {"take","exception"})
    public void testTakeBiscuitWhenNoneAvailable() {
        biscuit.takeBiscuit(20);
        biscuit.takeBiscuit(1);
        Assert.assertEquals(biscuit.getBiscuitCount(), 0);
    }
}