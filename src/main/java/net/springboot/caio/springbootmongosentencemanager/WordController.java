package net.springboot.caio.springbootmongosentencemanager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springboot.caio.springbootmongosentencemanager.model.Word;
import net.springboot.caio.springbootmongosentencemanager.service.WordService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/word")
@Slf4j
public class WordController {

    private WordService wordService;

    @GetMapping("/list")
    public ResponseEntity<List<Word>> getAllWords(){
        return ResponseEntity.ok().body(wordService.getAllWords());
    }

    @GetMapping
    public ResponseEntity<Word> getByWord(@RequestBody Word word){
        log.info("getByWord :"+word.getWord());
        return ResponseEntity.ok().body(wordService.getByWord(word.getWord()));
    }

    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody Word word){
        return ResponseEntity.ok().body(wordService.createWord(word));
    }

    @PutMapping("/update")
    public ResponseEntity<Word> updateWord(@RequestBody Word word){
        return  ResponseEntity.ok().body(wordService.updateWord(word));
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteWord(@RequestBody Word word){
        wordService.deleteWordById(word.getId());
        return HttpStatus.OK;
    }

    @GetMapping("/language")
    public ResponseEntity<List<Word>> getByLanguage(HttpServletRequest request){
        String language= String.valueOf(request.getHeader("language"));
        log.info("language :" +language);
        return ResponseEntity.ok().body(wordService.getAllWordsByLanuage(language));
    }

}
