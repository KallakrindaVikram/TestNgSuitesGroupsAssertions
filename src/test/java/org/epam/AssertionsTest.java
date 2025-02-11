package org.epam;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        Assert.assertEquals(10 + 5, 15);
    }

    @Test
    public void testAssertNotEquals() {
        Assert.assertNotEquals(5 + 5, 20);
    }

    @Test
    public void testAssertTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        boolean condition = 5%2==0;
        Assert.assertFalse(condition);
    }

    @Test
    public void testAssertNull() {
        Object obj = null;
        Assert.assertNull(obj);
    }

    @Test
    public void testAssertNotNull() {
        Object obj = new Object();
        Assert.assertNotNull(obj);
    }

    @Test
    public void testAssertSame() { // if pointing to the same object
        Integer a = 5;
        Integer b = a;
        Assert.assertSame(b, a);
    }

    @Test
    public void testAssertNotSame() {
        Integer a = 5;
        Integer b = new Integer(5);
        Assert.assertNotSame(b, a);
    }

    @Test
    public void testFail() {
        try {
            int result = 5/0;
            Assert.fail("Should have thrown an exception");
        } catch (ArithmeticException e) {
            // expected exception
        }
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAssertEqualsNoOrder() {
        Integer[] expected = {1, 2, 3};
        Integer[] actual = {1, 3, 2};
        Assert.assertEqualsNoOrder(actual, expected);
    }

    @Test
    public void testAssertNotEqualsNoOrder() {
        Integer[] expected = {1, 2, 3};
        Integer[] actual = {1, 3, 2};
        Assert.assertEqualsNoOrder(actual, expected);
    }

    @Test
    public void testAssertIterableEquals() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = Arrays.asList(1, 2, 3);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testAssertThrows() { //use this, better
            int result = 5 / 0;
        }

    @Test
    public void testAssertThrowsMethod() { //used when whatever u have can be fit in a lambda
        Assert.assertThrows(ArithmeticException.class, () -> {
            int result = 5 / 0;
        });
    }

}