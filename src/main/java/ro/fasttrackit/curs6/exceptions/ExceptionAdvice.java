package ro.fasttrackit.curs6.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(InvalidProductException.class)
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleInvalidProduct(InvalidProductException ex){
        return new ErrorResponse("IP001", ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    ErrorResponse handleResourceNotFound(ResourceNotFoundException ex){
        return new ErrorResponse("RNF01", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ErrorResponse handleAllExceptions(Exception ex) {
        log.error("Generic error", ex);
        return new ErrorResponse("GENERIC", "Internal error ocured. Please check logs");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ErrorResponse handleEnumException(Exception ex) {
        log.error("JSON parser", ex);
        return new ErrorResponse("JPE01", "Could not parse Product Info. Please check that product category is one of [VIDEO, APPLIANCE, LIGHT, PHONES]");
    }

}

record ErrorResponse(String code, String message){

}
