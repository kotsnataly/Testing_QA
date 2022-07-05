package boxes;

import fruits.Apple;
import fruits.Fruits;
import fruits.Orange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class A_BoxTest {

    @Test
    void getWeight() {

        OrangeBox ob = giveOrangeBox(); // size = 4
        AppleBox ab = giveAppleBox(); // size = 4
        AppleBox ab1 = giveAppleBox(); // size = 4
        //проверяем работу метода получаещего вес коробки, сравниваем вес. Ожидаем false.
        Assertions.assertFalse(ab.getWeight() == ob.getWeight());

        //проверяем работу метода получаещего вес коробки, сравниваем вес. Ожидаем true.
        Assertions.assertTrue(ab.getWeight() == ab1.getWeight());

        //проверяем работу метода получаещего вес, ожиадем NotNull.
        Assertions.assertNotNull(ab.getWeight());

    }

    @Test
    void compare() {
        OrangeBox ob = giveOrangeBox();
        AppleBox ab = giveAppleBox();
        AppleBox ab1 = giveAppleBox();

        //проверяем работу метода compare.
        Assertions.assertTrue(ab.compare(ab1));
        Assertions.assertFalse(ab.compare(ob));
    }

    @Test
    void moveFruits() {
        OrangeBox ob = giveOrangeBox();
        AppleBox ab = giveAppleBox();
        AppleBox ab1 = giveAppleBox();

        //пытаемся переложить яблоки в коробку с апельсинами. ожидаем false.
        Assertions.assertFalse(ab.moveFruits(ob, 1));

        //перкладываем из одной коробки с яблоками в другую коробку с яблоками
        Assertions.assertTrue(ab.moveFruits(ab1, 1));

        //пытаемся переложить большее количество чем есть в коробке
        Assertions.assertFalse(ab.moveFruits(ab1, 6));
    }

    AppleBox giveAppleBox() {
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        AppleBox appleBox = new AppleBox();
        ArrayList<Apple> apples = new ArrayList<>(Arrays.asList(apple, apple1, apple2, apple3));
        appleBox.boxOfFruits.addAll(apples);

        ArrayList<AppleBox> appleBoxes = new ArrayList<>();
        appleBoxes.add(appleBox);
        return appleBox;
    }

    OrangeBox giveOrangeBox() {
        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        OrangeBox orangeBox = new OrangeBox();

        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(orange, orange1, orange2, orange3));
        orangeBox.boxOfFruits.addAll(oranges);
        return orangeBox;
    }
}