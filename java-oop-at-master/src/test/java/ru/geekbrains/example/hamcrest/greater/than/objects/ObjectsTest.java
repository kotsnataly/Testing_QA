package ru.geekbrains.example.hamcrest.greater.than.objects;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;

public class ObjectsTest {

    @Test
    void sameInstanceTest() {
        String name = "Лорд";
        Dog dog1 = new Dog(name);
        Dog dog2 = dog1;

        MatcherAssert.assertThat(dog1, sameInstance(dog2));
    }



    @Test
    void hasToStringTest() {
        String name = "Лорд";
        Dog dog1 = new Dog(name);
        MatcherAssert.assertThat(dog1, hasToString("мое имя Лорд"));
    }


    @Test
    void instanceOfTest() {
        String name = "Лорд";
        Dog dog1 = new Dog(name);
        MatcherAssert.assertThat(dog1, instanceOf(Object.class));
    }


    @Test
    void typeCompatibleWithTest() {
        MatcherAssert.assertThat(Dog.class, typeCompatibleWith(Object.class));
    }

    @Test
    void hasPropertyTest() {
        Dog dog = new Dog("Лорд");
        assertThat(dog, hasProperty("name", equalTo("Лорд")));
    }


    @Test
    void samePropertyValuesAsTest() {
        Dog dog1 = new Dog("Лорд");
        Dog dog2 = new Dog("Лорд1");
        assertThat(dog1, samePropertyValuesAs(dog2));
    }


}
