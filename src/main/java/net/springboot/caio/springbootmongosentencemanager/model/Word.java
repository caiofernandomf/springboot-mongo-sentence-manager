package net.springboot.caio.springbootmongosentencemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Words")
public class Word {
    @Id
    private String id;
    @TextIndexed
    private String word;

    private String sentence;
}
