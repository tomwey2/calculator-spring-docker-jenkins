package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    
    private final CalculatorService calculatorService = new CalculatorService();
    
    @Test
    void square_PositiveNumber_ReturnsCorrectSquare() {
        double result = calculatorService.square(5.0);
        assertEquals(25.0, result, 0.0001);
    }
    
    @Test
    void square_NegativeNumber_ReturnsCorrectSquare() {
        double result = calculatorService.square(-3.0);
        assertEquals(9.0, result, 0.0001);
    }
    
    @Test
    void square_Zero_ReturnsZero() {
        double result = calculatorService.square(0.0);
        assertEquals(0.0, result, 0.0001);
    }
    
    @Test
    void square_DecimalNumber_ReturnsCorrectSquare() {
        double result = calculatorService.square(2.5);
        assertEquals(6.25, result, 0.0001);
    }
}