package org.epam.baseTestClasses;

import org.epam.Coffee;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CoffeeTest {
    private Coffee coffee;

    @BeforeMethod
    public void setUp() {
        coffee = new Coffee(10);
    }

    @AfterMethod
    public void tearDown() {
        coffee = null;
    }

    @Test
    public void testDispenseCoffeeNormal() {
        coffee.dispenseCoffee(5);
        Assert.assertEquals(coffee.getCoffeeCount(), 5);
    }

    @Test
    public void testLoadCoffeeNormal() {
        coffee = new Coffee(5);  // Reset to a different initial state
        coffee.loadCoffee(5);
        Assert.assertEquals(coffee.getCoffeeCount(), 10);
    }

    @Test
    public void testLoadCoffeeToFullMachine() {
        coffee.loadCoffee(0);
        Assert.assertEquals(coffee.getCoffeeCount(), 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testLoadCoffeeOverflow() {
        coffee.loadCoffee(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDispenseMoreCoffeeThanAvailable() {
        coffee.dispenseCoffee(11);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDispenseCoffeeWhenNoneAvailable() {
        coffee = new Coffee(0);
        coffee.dispenseCoffee(1);
    }
}