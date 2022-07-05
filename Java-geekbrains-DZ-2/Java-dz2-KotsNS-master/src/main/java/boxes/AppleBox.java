package boxes;

import fruits.Apple;

public class AppleBox<T extends Apple> extends A_Box {


    public boolean addFruit(T fruit) {
        return this.boxOfFruits.add(fruit);
    }

}
