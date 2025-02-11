package org.epam.groups;

import org.epam.Coffee;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CoffeeGroupsTest {
    private Coffee coffee;

    @BeforeMethod(groups = {"put","take","exception"})
    public void setUp() {
        coffee = new Coffee(10);
    }

    @AfterMethod(groups = {"put","take","exception"})
    public void tearDown() {
        coffee = null;
    }

    @Test(groups = {"take"})
    public void testDispenseCoffeeNormal() {
        coffee.dispenseCoffee(5);
        Assert.assertEquals(coffee.getCoffeeCount(), 5);
    }

    @Test(groups = {"put"})
    public void testLoadCoffeeNormal() {
        coffee = new Coffee(5);
        coffee.loadCoffee(5);
        Assert.assertEquals(coffee.getCoffeeCount(), 10);
    }

    @Test(groups = {"put"})
    public void testLoadCoffeeToFullMachine() {
        coffee.loadCoffee(0);
        Assert.assertEquals(coffee.getCoffeeCount(), 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"put","exception"})
    public void testLoadCoffeeOverflow() {
        coffee.loadCoffee(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"take","exception"})
    public void testDispenseMoreCoffeeThanAvailable() {
        coffee.dispenseCoffee(11);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"take","exception"})
    public void testDispenseCoffeeWhenNoneAvailable() {
        coffee = new Coffee(0);
        coffee.dispenseCoffee(1);
    }

    @Test(groups = {"take","put"})
    public void multipleGroupsExample(){
        System.out.println("This will run in all the groups");
    }

}