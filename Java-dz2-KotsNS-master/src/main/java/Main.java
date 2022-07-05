import boxes.AppleBox;
import boxes.OrangeBox;
import fruits.Apple;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        AppleBox appleBox = new AppleBox();

        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        OrangeBox orangeBox = new OrangeBox();

        ArrayList<Apple> apples = new ArrayList<>(Arrays.asList(apple, apple1, apple2, apple3));
        appleBox.boxOfFruits.addAll(apples);

        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(orange, orange1, orange2, orange3));
        orangeBox.boxOfFruits.addAll(oranges);

        AppleBox appleBox1 = new AppleBox();
        appleBox.moveFruits(appleBox1, 2);

        System.out.println(appleBox.moveFruits(orangeBox, 2));
    }
}
