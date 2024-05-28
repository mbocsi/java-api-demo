package com.example.springAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String Index() {
        return "Hello world!";
    }

    @GetMapping("/api/getListings")
    public String getListings() {
        return "Ha! You thought you would be getting listings? Fool...";
    }
}
