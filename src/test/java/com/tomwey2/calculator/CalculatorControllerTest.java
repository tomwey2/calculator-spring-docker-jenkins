package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void squareEndpointTest() throws Exception {
        // Arrange
        int input = 2;
        int expectedResult = 4;
        when(calculatorService.square(input)).thenReturn(expectedResult);

        // Act & Assert
        mockMvc.perform(get("/square").param("x", String.valueOf(input)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedResult)));
    }

    @Test
    public void squareEndpointTestWithNegativeInput() throws Exception {
        // Arrange
        int input = -3;
        int expectedResult = 9;
        when(calculatorService.square(input)).thenReturn(expectedResult);

        // Act & Assert
        mockMvc.perform(get("/square").param("x", String.valueOf(input)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedResult)));
    }

    @Test
    public void squareEndpointTestWithZeroInput() throws Exception {
        // Arrange
        int input = 0;
        int expectedResult = 0;
        when(calculatorService.square(input)).thenReturn(expectedResult);

        // Act & Assert
        mockMvc.perform(get("/square").param("x", String.valueOf(input)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedResult)));
    }
}