package com.project.template.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.template.exception.EntityNotFoundException;

@ControllerAdvice
public class SampleExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle Internal Server Error.
     *
     * @param exception the caught exception
     * @param request   the intercepted request
     * @return the resources
     */
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerError(
            final RuntimeException exception, final WebRequest request) {
        return new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle Entity Not Found Exception.
     *
     * @param exception the caught exception
     * @param request   the intercepted request
     * @return the resources
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            final RuntimeException exception, final WebRequest request) {
        return new ResponseEntity<>(
                exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
