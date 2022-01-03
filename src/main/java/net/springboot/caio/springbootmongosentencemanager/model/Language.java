package net.springboot.caio.springbootmongosentencemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.springboot.caio.springbootmongosentencemanager.exception.WordNotFoundException;

import java.util.stream.Stream;
@AllArgsConstructor
@Getter
public enum Language {

    EN("EN","ENGLISH"),
    ES("ES","ESPANISH");

    private final String id;
    private final String name;


    public static Language fromName(String name){
        return Stream.of(Language.values())
                .filter(language ->
                        language.getName().contains(name.toUpperCase())
                        || language.getId().equals(name.toUpperCase()))
                .findFirst()
                .orElseThrow(() ->new WordNotFoundException("Language not found [ "+name+" ]"));
    }

}
