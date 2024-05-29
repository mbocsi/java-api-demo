package com.example.springAPI;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListingsControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void listings() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/api/listings", String.class);
        assertThat(response.getBody()).isEqualTo("{\"success\":true,\"listings\":[{\"id\":2167,\"userId\":\"user_6723722\",\"name\":\"Office chair\",\"askingPrice\":20.0},{\"id\":7323,\"userId\":\"user_1562722\",\"name\":\"ECE 340 Textbook\",\"askingPrice\":22.0},{\"id\":3425,\"userId\":\"user_7865375\",\"name\":\"Keyboard\",\"askingPrice\":15.0},{\"id\":9234,\"userId\":\"user_7458744\",\"name\":\"Couch\",\"askingPrice\":40.0},{\"id\":2562,\"userId\":\"user_9345643\",\"name\":\"Plates\",\"askingPrice\":12.5}]}");
    }
}