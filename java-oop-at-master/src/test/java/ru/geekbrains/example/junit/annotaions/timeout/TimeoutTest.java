package ru.geekbrains.example.junit.annotaions.timeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;

public class TimeoutTest {

    @Timeout(value = 4)
    @Test
    void name() throws InterruptedException {
        sleep(3000);
    }

}
