package ru.geekbrains.example.junit.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertFailTest {
    @Test
    void name() {
        Assertions.fail("тест упадет всегда");
    }
}
