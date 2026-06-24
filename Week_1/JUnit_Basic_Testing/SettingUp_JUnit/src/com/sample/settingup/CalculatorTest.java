package com.sample.settingup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	
    @Test
    public void testAdd() {

        Calculator calculator = new Calculator();

        assertEquals(50, calculator.add(20, 30));
    }
}