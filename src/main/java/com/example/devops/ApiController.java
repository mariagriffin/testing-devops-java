package com.example.devops;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private final Calculator calc = new Calculator();

    @GetMapping("/api/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calc.add(a, b);
    }

    @GetMapping("/api/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return calc.divide(a, b);
    }
}
