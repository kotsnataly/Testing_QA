package ru.geekbrains.example.junit.assertions.equals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsTest {
    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void name() {
        assertEquals("Лорд", "Лорд");
    }
}
