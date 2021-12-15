package net.springboot.caio.springbootmongosentencemanager.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class WordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -811810510358845054L;

    public WordNotFoundException(String message) {
        super(message);
    }

    public WordNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
