package com.soccer.exceptions.handler;

import com.soccer.exceptions.badrequestexception.BadRequestException;
import com.soccer.exceptions.details.ExceptionDetailsBadRequest;
import com.soccer.exceptions.details.ExceptionDetailsNotFound;
import com.soccer.exceptions.details.ExceptionMethodNotValidDetails;
import com.soccer.exceptions.details.ExceptionServerErrorDetails;
import com.soccer.exceptions.notfound.NotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionDetailsNotFound handlerNotFoundException(NotFoundException notFoundException){
        return ExceptionDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(notFoundException.getMessage())
                .developerMessage("Enter a valid ID. Be sure this value exists.")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionMethodNotValidDetails handlerMethodNotValid(MethodArgumentNotValidException argumentNotValidException){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = argumentNotValidException.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        return ExceptionMethodNotValidDetails.builder()
                .status(BAD_REQUEST.value())
                .title("Not valid details")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check for incorrect information.")
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionDetailsBadRequest handlerBadRequest(BadRequestException badRequestException){
        return ExceptionDetailsBadRequest.builder()
                .status(BAD_REQUEST.value())
                .title("Bad request")
                .timestamp(Instant.now())
                .details(badRequestException.getMessage())
                .developerMessage("the server did not understand your request!")
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionServerErrorDetails handlerServerError(){
        return ExceptionServerErrorDetails.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .title("Internal server error")
                .timestamp(Instant.now())
                .details("some unexpected error occurred")
                .developerMessage("the application raised an unhandled exception")
                .build();
    }

}
