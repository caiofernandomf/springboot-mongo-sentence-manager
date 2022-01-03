package net.springboot.caio.springbootmongosentencemanager.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springboot.caio.springbootmongosentencemanager.exception.WordNotFoundException;
import net.springboot.caio.springbootmongosentencemanager.exception.WordsAlreadyExistsException;
import net.springboot.caio.springbootmongosentencemanager.model.Language;
import net.springboot.caio.springbootmongosentencemanager.model.Word;
import net.springboot.caio.springbootmongosentencemanager.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class WodServiceImpl implements WordService{

    private WordRepository wordRepository;

    @Override
    public Word createWord(Word word) {
        word.setIdiom(Language.fromName(word.getIdiom()).getId());
        return wordRepository.insert(word);
    }

    @Override
    public Word updateWord(Word word) {
        word.setIdiom(Language.fromName(word.getIdiom()).getId());
        return wordRepository.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> getAllWordsByLanuage(String language) {

        List<Word> wordO = wordRepository
                    .findAllByLanguage(
                            Language
                                    .fromName(language)
                                    .getId());

        return wordO;
    }

    public Word getByWord(String word){
        Optional<Word> wordO = null;

        wordO= Optional.ofNullable(wordRepository.findByWord(word));

        if(!wordO.isPresent())
            throw new WordNotFoundException("Word :"+word+" not found!");

        return wordO.get();
    }

    @Override
    public void deleteWord(Word word) {
        wordRepository.delete(word);
    }

    @Override
    public void deleteWordById(String id){
        wordRepository.deleteById(id);
    }

    @Override
    public Collection<Word> insertMany(Collection<Word> words) {
        List allWords = getAllWords();

        List<Word> wordsNonDuplicated =
            words
                .stream()
                .filter(w ->
                        allWords
                                .stream()
                                .noneMatch(o -> o.equals(w)))
                .collect(Collectors.toList());

        if(!wordsNonDuplicated.isEmpty())
            return wordRepository.saveAll(wordsNonDuplicated);
        else {
            log.info("List is empty");
            throw new WordsAlreadyExistsException("Words already exists !!!");
        }

    }
}
