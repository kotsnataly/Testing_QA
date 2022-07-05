package ru.geekbrains.example.hamcrest.greater.than;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.*;

public class StringTest {

    @Test
    void equalToIgnoringCaseTest() {
        String name1 = "Лорд";
        String name2 = "лоРД";

        MatcherAssert.assertThat("ЛоРд", equalToIgnoringCase(name1));

        Assertions.assertEquals("ЛоРд", name1);
    }

    @Test
    void containsStringTest() {
        String name1 = "Лорд GeekBrains Лорд Лорд Лорд";

        MatcherAssert.assertThat(name1, containsString("GeekBrains"));

    }

    @Test
    void endsWithTest() {
        String name1 = "Лорд GeekBrains Лорд Лорд Лорд";
        MatcherAssert.assertThat(name1, endsWith("GeekBrains Лорд Лорд Лорд"));
    }

    @Test
    void equalToCompressingWhiteSpaceTest() {
        String name1 = "Лорд GeekBrains Лорд Лорд          Лорд";
        MatcherAssert.assertThat(name1, equalToCompressingWhiteSpace("Лорд GeekBrains Лорд Лорд Лорд"));
    }

}
