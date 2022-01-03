package net.springboot.caio.springbootmongosentencemanager.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class WordsAlreadyExistsException extends RuntimeException {

    public WordsAlreadyExistsException(String message) {
        super(message);
    }

    public WordsAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
