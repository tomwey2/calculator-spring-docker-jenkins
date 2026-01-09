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
    public void testSquareEndpoint() throws Exception {
        mockMvc.perform(get("/square").param("x", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("16"));

        mockMvc.perform(get("/square").param("x", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));

        mockMvc.perform(get("/square").param("x", "-5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25"));
    }
}