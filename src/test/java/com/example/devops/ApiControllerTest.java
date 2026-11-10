package com.example.devops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApiController.class)
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/api/add").param("a", "5").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void testDivideEndpoint() throws Exception {
        mockMvc.perform(get("/api/divide").param("a", "6").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

    @Test
    void testDivideByZeroReturns400() throws Exception {
        mockMvc.perform(get("/api/divide").param("a", "4").param("b", "0"))
                .andExpect(status().is4xxClientError());
    }
}
