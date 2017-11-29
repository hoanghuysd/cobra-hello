package org.cobra.web.error.exceptionhandler;

import org.cobra.persistence.dto.ArticleDto;
import org.cobra.web.error.exception.CbIOFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Hoang Huy on 11/5/2017.
 */
@RestControllerAdvice
public class RestResponseEntityExceptionHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(CbIOFileException.class)
    protected ResponseEntity<Object> handleInternal(final CbIOFileException ex, final WebRequest request) {
        ArticleDto user =new ArticleDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Has error message");
        return new ResponseEntity<Object>(user,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNotFound(final Exception  ex, final WebRequest request) {
        ArticleDto user =new ArticleDto(HttpStatus.NOT_FOUND.value(),"Has error message");
        //ex.printStackTrace();
        return new ResponseEntity<Object>(user,HttpStatus.NOT_FOUND);
    }
}
