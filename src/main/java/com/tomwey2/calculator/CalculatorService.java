package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, intint b) {
        return a + b;
    }
    
    public int square(int x) {
        return x * x;
    }
}