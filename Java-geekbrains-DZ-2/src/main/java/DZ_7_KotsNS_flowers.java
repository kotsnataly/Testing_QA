import java.awt.*;
import java.util.*;

public class DZ_7_KotsNS_flowers {
    public static void main(String[] args) {
        ArrayList<String> flowers = new ArrayList<>();
        flowers.add("Пион");
        flowers.add("Роза");
        flowers.add("Пион");
        flowers.add("Тюльпан");
        flowers.add("Гвоздика");
        flowers.add("Ромашка");
        flowers.add("Хризантема");
        flowers.add("Гербер");
        flowers.add("Роза");
        flowers.add("Пион");
        flowers.add("Ромашка");
        flowers.add("Лилия");
        flowers.add("Флокс");
        flowers.add("Гвоздика");
        flowers.add("Хризантема");
        flowers.add("Ирис");
        flowers.add("Тюльпан");
        flowers.add("Гербер");
        flowers.add("Роза");
        flowers.add("Пион");
        System.out.println(flowers);
        HashSet<String> uniqFlowers = new HashSet<>();
        for (String s : flowers) {
            uniqFlowers.add(s);
        }
        System.out.println(uniqFlowers);
        HashMap<String, Integer> countFlowers = new HashMap<>();
        for (String s : flowers) {
            if (countFlowers.containsKey(s)) {
                countFlowers.put(s, countFlowers.get(s) + 1);
            } else {
                countFlowers.put(s,1);
            }
        }
        System.out.println(countFlowers);
    }

}
