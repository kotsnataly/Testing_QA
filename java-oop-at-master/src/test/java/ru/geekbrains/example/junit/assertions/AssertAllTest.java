package ru.geekbrains.example.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertAllTest {

    @Test
    void name1() {
        assertAll("Пользователь",
                () -> assertEquals("Иван", "Петр"),
                () -> assertEquals("Иванов", "Васильев")
        );
    }
}
