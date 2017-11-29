package org.cobra.web.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Hoang Huy on 11/5/2017.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CbIOFileException extends  Exception{
    public CbIOFileException(){
        super();
    }
    public CbIOFileException(String message, Throwable cause) {
        super(message, cause);
    }
    public CbIOFileException(String message) {
        super(message);
    }
    public CbIOFileException(Throwable cause) {
        super(cause);
    }
}
