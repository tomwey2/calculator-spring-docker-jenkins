package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void squareEndpointShouldReturnSquareOfPositiveNumber() throws Exception {
        mockMvc.perform(get("/square").param("x", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25"));
    }

    @Test
    void squareEndpointShouldReturnSquareOfNegativeNumber() throws Exception {
        mockMvc.perform(get("/square").param("x", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("9"));
    }

    @Test
    void squareEndpointShouldReturnSquareOfZero() throws Exception {
        mockMvc.perform(get("/square").param("x", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void squareEndpointShouldReturnSquareOfMaxInteger() throws Exception {
        mockMvc.perform(get("/square").param("x", String.valueOf(Integer.MAX_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf((long) Integer.MAX_VALUE * Integer.MAX_VALUE)));
    }

    @Test
    void squareEndpointShouldReturnSquareOfMinInteger() throws Exception {
        mockMvc.perform(get("/square").param("x", String.valueOf(Integer.MIN_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf((long) Integer.MIN_VALUE * Integer.MIN_VALUE)));
    }

}