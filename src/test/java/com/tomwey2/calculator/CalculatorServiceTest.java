package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sumTest() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    public void squareTest() {
        assertEquals(25.0, calculatorService.square(5.0));
        assertEquals(0.0, calculatorService.square(0.0));
        assertEquals(2.25, calculatorService.square(1.5));
        assertEquals(100.0, calculatorService.square(-10.0));
    }
}
