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
        assertEquals(4, calculatorService.square(2));
        assertEquals(9, calculatorService.square(-3));
        assertEquals(0, calculatorService.square(0));
        assertEquals(25, calculatorService.square(5));
        assertEquals(4611686014132420609L, calculatorService.square(Integer.MAX_VALUE));
        assertEquals(4611686018427387904L, calculatorService.square(Integer.MIN_VALUE));
    }
    
}
