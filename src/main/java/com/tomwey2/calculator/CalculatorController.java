package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public String add(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(calculatorService.subtract(a, b));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(calculatorService.divide(a, b));
    }
}