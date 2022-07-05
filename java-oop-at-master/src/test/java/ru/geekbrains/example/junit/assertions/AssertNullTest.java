package ru.geekbrains.example.junit.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertNullTest {
    @Test
    void name1() {
        String dogName = "Лорд";

        Assertions.assertNull(dogName);
    }

    @Test
    void name2() {
        String dogName =null;

        Assertions.assertNull(dogName);
    }
}
