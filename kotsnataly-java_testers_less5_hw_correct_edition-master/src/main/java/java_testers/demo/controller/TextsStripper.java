package java_testers.demo.controller;

import java.io.*;
import java.util.TreeMap;

public class TextsStripper implements AutoCloseable {
    private FileInputStream fis;
    private BufferedReader openedFile;
    private int counterOfEachWord;
    private TreeMap<String, Integer> mapOfWords = new TreeMap<>();

    public TreeMap<String, Integer> getMapOfWords() {
        return mapOfWords;
    }


    //открываем файл.
    public boolean openFile(String name) {
        try {
            fis = new FileInputStream(name);
            openedFile = new BufferedReader(new InputStreamReader(fis));
            System.out.println("Файл открыт для работы.");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return false;
        }
    }

    //сам поиск по тексту.
    public void findWordAndCountIt(String word) throws IOException {
        counterOfEachWord = 0;
        System.out.println("reading lines");
        String stringToParse = openedFile.readLine();
        while (stringToParse != null) {
            String[] wordsForEqualitation = stringToParse.split(" ");

            for (String s : wordsForEqualitation) {
                s = stripWord(s);
                if (s.equals(word)) {
                    counterOfEachWord++;
                    mapOfWords.put(word, counterOfEachWord);
                } else {
                    mapOfWords.put(word, counterOfEachWord);
                }
            }
            stringToParse = openedFile.readLine();
        }
    }

    //удаляем небуквенные символы в токене.
    public String stripWord(String wordToStrip) {
        return wordToStrip.replaceAll("[^A-z]+", "").toLowerCase();
    }

    public void searchTheWords(String string) throws IOException {
        String[] strings = string.split(" ");
        for (String s : strings) {
            s = stripWord(s);
            System.out.println("Searching..." + s);
            findWordAndCountIt(s);
            //возвращаем BufferedReafer после отработки подсчета слова на начало файла.
            fis.getChannel().position(0);
            openedFile = new BufferedReader(new InputStreamReader(fis));
        }

    }

    @Override
    public void close() throws Exception {
        fis.close();
        openedFile.close();
    }
}
