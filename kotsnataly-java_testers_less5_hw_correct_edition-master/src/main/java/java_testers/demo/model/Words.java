package java_testers.demo.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.*;

@Entity
public class Words extends AbstractPersistable<TreeMap> {

    @ElementCollection
    private Map<String, Integer> wordsAndCounters = new LinkedHashMap<>();

    public Map<String, Integer> getWordsAndCounters() {
        return sortMyMap(wordsAndCounters);
    }

    public void setWordsAndCounters(Map<String, Integer> wordsAndCounters) {
        this.wordsAndCounters = wordsAndCounters;
    }

    //сортировка Map в обратном порядке, спасибо StackOverflow...
    private <K, V extends Comparable<? super V>> Map<K, V> sortMyMap(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Words{" +
                "wordsAndCounters=" + wordsAndCounters +
                '}';
    }
}
