package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTestWithAAA {

    private Calculator calculator;

    @Before
    public void setUp() {
        // This runs BEFORE each test
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }

    @After
    public void tearDown() {
        // This runs AFTER each test
        calculator = null;
        System.out.println("Teardown: Calculator instance set to null.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }
}
