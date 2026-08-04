package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SquareRequest;
import com.tomwey2.calculator.dto.SquareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @PostMapping("/square")
    SquareResponse square(@RequestBody SquareRequest request) {
        double result = calculatorService.square(request.getX());
        SquareResponse response = new SquareResponse();
        response.setResult(result);
        return response;
    }
}
