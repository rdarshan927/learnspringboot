package com.rd927.second;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

public class DummyController {
    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page!";
    }
}
