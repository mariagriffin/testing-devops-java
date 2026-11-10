package com.example.devops;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ApiController {

    private final Calculator calc = new Calculator();

    @GetMapping("/api/add")
    public int add(
            @RequestParam("a") int a,
            @RequestParam("b") int b) {

        return calc.add(a, b);
    }

    @GetMapping("/api/divide")
    public int divide(
            @RequestParam("a") int a,
            @RequestParam("b") int b) {

        try {
            return calc.divide(a, b);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }
    }
}