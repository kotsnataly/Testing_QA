package ru.geekbrains.example.hamcrest.greater.than;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;

public class IntegerTest {

    @Test
    void greaterThanTest() {
        int numberActual = 100;
        int numberExpected = 90;

        MatcherAssert.assertThat(numberActual, greaterThan(numberExpected));
    }

    @Test
    void lessThanOrEqualToTest() {
        int numberActual = 50;
        int numberExpected = 100;

        MatcherAssert.assertThat(numberActual, lessThanOrEqualTo(numberExpected));
    }

    @Test
    void closeToTest() {
        double numberActual = 100.00;
        double numberExpected = 98.00;

        MatcherAssert.assertThat(numberActual, closeTo(numberExpected, 2));
    }

}
