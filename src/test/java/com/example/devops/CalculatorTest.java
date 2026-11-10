package com.example.devops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addsNumbersCorrectly() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void dividesNumbersCorrectly() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void throwsOnDivideByZero() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calc.divide(4, 0));
        assertEquals("Division by zero", e.getMessage());
    }
}
