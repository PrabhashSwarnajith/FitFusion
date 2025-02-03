package lk.fitfusion.fitfusion_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CustomerNotFoundException.class , CLException.class, UserNotFoundException.class})
    public void handelException (Exception e){
        System.out.println("Exception Occurred " + e.getMessage());
    }
}
