package ru.geekbrains.example.junit.annotaions.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ParameterizedExampleTest {


    @ParameterizedTest
    @ValueSource(strings = {"Том", "Джерри"})
    void hardcode(String name) {
        Assertions.assertNotNull(name);
    }

    @ParameterizedTest
    @MethodSource("listName")
    void method(String name) {
        Assertions.assertNotNull(name);
    }

    public static Stream<String> listName() {
        return Stream.of("Ларри", "Кинг");
    }


    @ParameterizedTest
    @MethodSource("listNameMulti")
    void methodMulti(String name, Integer age) {
        Assertions.assertNotNull(name);
        Assertions.assertNotNull(age);
    }

    public static Stream<Arguments> listNameMulti() {
        return Stream.of(
                Arguments.of("Том", 5),
                Arguments.of("Джерри", null)
        );
    }
}
