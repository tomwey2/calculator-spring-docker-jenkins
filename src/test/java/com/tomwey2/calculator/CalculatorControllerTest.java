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
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void squareEndpointReturnsCorrectResult() throws Exception {
        mockMvc.perform(get("/square").param("x", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("16"));
    }

    @Test
    void squareEndpointReturnsZeroForZeroInput() throws Exception {
        mockMvc.perform(get("/square").param("x", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void squareEndpointReturnsOneForNegativeOneInput() throws Exception {
        mockMvc.perform(get("/square").param("x", "-1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

}
