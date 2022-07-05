package java_testers.demo.repository;

import java_testers.demo.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsCounter extends JpaRepository<Words, Integer> {
}
