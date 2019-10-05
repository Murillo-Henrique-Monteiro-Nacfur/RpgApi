package rpgtcc.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
class CustomAccessDeniedException extends RuntimeException{
    public CustomAccessDeniedException(String ex){
        super(ex);
    }
}
