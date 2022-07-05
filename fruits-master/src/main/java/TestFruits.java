public class TestFruits {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        for (int i = 0; i < 3; i++) {
            appleBox.addFruit(new Apple());
        }

        System.out.println("В этой коробке " + appleBox.getCommonWeight() + " килограмм яблок");

        for (int i = 0; i < 2; i++) {
            orangeBox.addFruit(new Orange());
        }
        System.out.println("В этой коробке " + orangeBox.getCommonWeight() + " килограмм апельсинов");

        System.out.println(appleBox.compare(orangeBox));

        appleBox.moveFruits(appleBox1, 2);
        orangeBox.moveFruits(orangeBox1, 1);

        System.out.println("После пересыпки осталось " + appleBox.getCommonWeight() + " килограмм яблок");
        System.out.println("После пересыпки осталось " + orangeBox.getCommonWeight() + " килограмм апельсинов");

        System.out.println(appleBox.compare(orangeBox));
    }

}
