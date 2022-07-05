import java.util.ArrayList;

public class Box<Fruit> {

    ArrayList<Fruit> listfruit = new ArrayList();

    boolean addFruit(Fruit fruitname) {
        return listfruit.add(fruitname);
    }

    float getCommonWeight() {
        if (listfruit.get(0).getClass().getSimpleName().equals("Apple")) {
            return listfruit.size() * 1.0f;
        } else {
            return listfruit.size() * 1.5f;
        }
    }

    boolean compare(Box box) {
        return this.getCommonWeight() == box.getCommonWeight();
    }

    boolean moveFruits(Box box, int quantity) {
        boolean success = true;
        System.out.println("Перемещаю фрукты");
        if (quantity > listfruit.size()) {
            return false;
        } else {
            for (int i = 0; i < quantity; i++) {
                success = box.addFruit(quantity);
                listfruit.remove(i);
            }
        }
        return success;
    }
}
