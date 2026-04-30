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
    public void squareTestPositive() {
        assertEquals(9, calculatorService.square(3));
    }
    
    @Test
    public void squareTestNegative() {
        assertEquals(9, calculatorService.square(-3));
    }
    
    @Test
    public void squareTestZero() {
        assertEquals(0, calculatorService.square(0));
    }
}