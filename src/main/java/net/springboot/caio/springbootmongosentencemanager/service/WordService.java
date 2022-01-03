package net.springboot.caio.springbootmongosentencemanager.service;

import net.springboot.caio.springbootmongosentencemanager.model.Word;

import java.util.Collection;
import java.util.List;

public interface WordService {
    Word createWord(Word word);

    Word updateWord(Word word);

    List<Word> getAllWords();

    Word getByWord(String word);

    List<Word> getAllWordsByLanuage(String language);

    void deleteWord(Word word);

    void deleteWordById(String id);

    Collection<Word> insertMany(Collection<Word> words);
}
