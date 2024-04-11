package com.admazsshipping.api.adapter.input.exception;

import com.admazsshipping.api.core.exception.FreteAlreadyExistsException;
import com.admazsshipping.api.core.exception.FreteNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(HttpClientErrorException.BadRequest ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(ChangeSetPersister.NotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerErrorException(HttpServerErrorException.InternalServerError ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Ocorreu um erro interno no servidor", null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(FreteAlreadyExistsException.class)
    public ResponseEntity<Object> handleFreteAlreadyExistsException(FreteAlreadyExistsException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(FreteNotFoundException.class)
    public ResponseEntity<Object> handleFreteNotFoundException(FreteNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.NOT_FOUND, request);
    }
}
