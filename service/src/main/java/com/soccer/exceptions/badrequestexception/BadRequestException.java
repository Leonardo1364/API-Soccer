package com.soccer.exceptions.badrequestexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class BadRequestException extends HttpClientErrorException {
    public BadRequestException(HttpStatus statusCode) {
        super(statusCode);
    }
}
