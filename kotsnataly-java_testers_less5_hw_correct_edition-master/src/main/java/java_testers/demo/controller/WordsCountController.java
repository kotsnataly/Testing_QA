package java_testers.demo.controller;

import java_testers.demo.model.Words;
import javafx.application.Application;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class WordsCountController {
    private ApplicationContext applicationContext;
    private TextsStripper textsStripper = new TextsStripper();

    @PostMapping("/books")
    public Map<String, Integer> countWords(@RequestBody String searchedWords) throws Exception {
        System.out.println("working with" + searchedWords);
        textsStripper.openFile("C:\\Users\\shakja\\IdeaProjects\\lesson4hw\\src\\main\\resources\\The Return of the King.txt");
        textsStripper.searchTheWords(searchedWords);
        Words words = new Words();
        words.setWordsAndCounters(textsStripper.getMapOfWords());
        System.out.println(words.getWordsAndCounters());
        textsStripper.close();
        return words.getWordsAndCounters();
    }
}
