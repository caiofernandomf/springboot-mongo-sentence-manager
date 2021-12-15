package net.springboot.caio.springbootmongosentencemanager.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springboot.caio.springbootmongosentencemanager.exception.WordNotFoundException;
import net.springboot.caio.springbootmongosentencemanager.model.Word;
import net.springboot.caio.springbootmongosentencemanager.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class WodServiceImpl implements WordService{

    private WordRepository wordRepository;

    @Override
    public Word createWord(Word word) {
        return wordRepository.insert(word);
    }

    @Override
    public Word updateWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> getAllWordsByLanuage(String language) {
        List<Word> wordO = null;
        try {
            wordO= wordRepository.findAllByLanguage(language);
        }catch (Exception e){
            log.error("Erro ao buscar por language : ",e);
        }
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
}
