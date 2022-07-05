package ru.geekbrains.example.junit.annotaions.display.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестовый набор")
public class DisplayNameTest {


    @DisplayName("Тестовый случай")
    @Test
    void name() {
        System.out.println("123");
    }
}
