package boxes;

import fruits.Apple;
import fruits.Orange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppleBoxTest {

    AppleBox ab = giveAppleBox();
    OrangeBox ob = giveOrangeBox();
    Apple apple = new Apple();
    Orange orange = new Orange();

    @Test
    void addFruit() {
        //тут на прекомпиляции появляется ошибка.
//        Assertions.assertFalse(ab.addFruit(orange));

        //проверка работы метода добавления соотвествующего фрукта.
        Assertions.assertTrue(ab.addFruit(apple));
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