package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public double square(double x) {
        return x * x;
    }
}
