package boxes;

import fruits.Fruits;

import java.util.ArrayList;

public abstract class A_Box<T extends Fruits> {
    public ArrayList<T> boxOfFruits = new ArrayList<>();

    public float getWeight() {
        return boxOfFruits.size() * boxOfFruits.get(0).weight;
    }

    public boolean compare(A_Box comaredBox) {
        return this.getWeight() == comaredBox.getWeight();
    }

    public boolean moveFruits(A_Box forTransfer, int qty) {
        if (qty > 0 && this.boxOfFruits.size() >= qty  && forTransfer.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
            forTransfer.boxOfFruits.addAll(0, this.boxOfFruits.subList(0, qty));
            this.boxOfFruits.removeAll(this.boxOfFruits.subList(0, qty));
            return true;
        } else {
            return false;
        }
    }
}
