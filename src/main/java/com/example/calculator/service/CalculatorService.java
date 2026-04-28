package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double square(double number) {
        return Math.pow(number, 2);
    }
}