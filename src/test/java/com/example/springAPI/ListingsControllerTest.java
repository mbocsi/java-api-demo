package com.example.springAPI;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ListingsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/listings").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"success\":true,\"listings\":[{\"id\":2167,\"userId\":\"user_6723722\",\"name\":\"Office chair\",\"askingPrice\":20.0},{\"id\":7323,\"userId\":\"user_1562722\",\"name\":\"ECE 340 Textbook\",\"askingPrice\":22.0},{\"id\":3425,\"userId\":\"user_7865375\",\"name\":\"Keyboard\",\"askingPrice\":15.0},{\"id\":9234,\"userId\":\"user_7458744\",\"name\":\"Couch\",\"askingPrice\":40.0},{\"id\":2562,\"userId\":\"user_9345643\",\"name\":\"Plates\",\"askingPrice\":12.5}]}")));
    }
}
