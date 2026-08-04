package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SquareRequest;
import com.tomwey2.calculator.dto.SquareResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void squareEndpointTest() {
        SquareRequest request = new SquareRequest();
        request.setX(5.0);

        ResponseEntity<SquareResponse> response = restTemplate.postForEntity(
                "/square",
                request,
                SquareResponse.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(25.0, response.getBody().getResult());
    }

    @Test
    public void squareEndpointWithZeroTest() {
        SquareRequest request = new SquareRequest();
        request.setX(0.0);

        ResponseEntity<SquareResponse> response = restTemplate.postForEntity(
                "/square",
                request,
                SquareResponse.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(0.0, response.getBody().getResult());
    }

    @Test
    public void squareEndpointWithNegativeTest() {
        SquareRequest request = new SquareRequest();
        request.setX(-3.0);

        ResponseEntity<SquareResponse> response = restTemplate.postForEntity(
                "/square",
                request,
                SquareResponse.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(9.0, response.getBody().getResult());
    }
}
