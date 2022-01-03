package net.springboot.caio.springbootmongosentencemanager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class WordExceptionHandler {

    @ExceptionHandler(value = {WordNotFoundException.class})
    public ResponseEntity<Object> handleWordNotFoundException(
            Exception exception,
            HttpServletRequest httpServletRequest
    ){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(httpStatus)
                .body(exception.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleWordsAlreadyExistsException(
            Exception exception,
            HttpServletRequest httpServletRequest
    ){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(httpStatus)
                .body(exception.getMessage());
    }
}
