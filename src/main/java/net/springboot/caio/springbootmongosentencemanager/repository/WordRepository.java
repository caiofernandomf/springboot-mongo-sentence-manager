package net.springboot.caio.springbootmongosentencemanager.repository;

import net.springboot.caio.springbootmongosentencemanager.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface WordRepository extends MongoRepository<Word,String> {

    @Query("{ 'word' : ?0 }")
    Word findByWord(String word);

    @Query("{'idiom': ?0 }")
    List<Word> findAllByLanguage(String language);
}
