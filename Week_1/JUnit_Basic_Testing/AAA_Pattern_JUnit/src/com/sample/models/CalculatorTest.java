package com.sample.models;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup Method Executed");
    }
    @After
    public void tearDown() {

        System.out.println("Teardown Method Executed");
    }
    @Test
    public void testAdd() {
        int a = 25;
        int b = 25;

        int result = calculator.add(a, b);
        assertEquals(50, result);
    }
}