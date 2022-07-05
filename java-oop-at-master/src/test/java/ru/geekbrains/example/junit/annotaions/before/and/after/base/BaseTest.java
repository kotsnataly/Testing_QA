package ru.geekbrains.example.junit.annotaions.before.and.after.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeAll
    static void beforeAllBaseTest() {
        System.out.println("BaseTest beforeAll");
    }


    @BeforeEach
    void setUp1BaseTest() {
        System.out.println("BaseTest setUp1");
    }

    @BeforeEach
    void setUp2BaseTest() {
        System.out.println("BaseTest setUp2");
    }

    @AfterEach
    void tearDownBaseTest() {
        System.out.println("BaseTest tearDown");
    }

    @AfterAll
    static void afterAllBaseTest() {
        System.out.println("BaseTest afterAll");
    }
}
