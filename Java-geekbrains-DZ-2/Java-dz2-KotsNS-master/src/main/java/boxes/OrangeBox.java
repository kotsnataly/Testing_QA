package boxes;

import fruits.Orange;

public class OrangeBox<T extends Orange> extends A_Box {


    public boolean addFruit(T fruit) {
        return this.boxOfFruits.add(fruit);
    }

}
