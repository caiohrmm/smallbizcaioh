package com.caiohenrique.smallbizjava.exceptions.handler;

import com.caiohenrique.smallbizjava.exceptions.ObjectNotFoundException;
import com.caiohenrique.smallbizjava.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
                                                                 HttpServletRequest request) {
        StandardError standardError = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Object Not Found", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequestException(BadRequestException ex,
                                                                 HttpServletRequest request) {
        StandardError standardError = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Bad Request", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErros(MethodArgumentNotValidException ex,
                                                                 HttpServletRequest request) {
        ValidationError validationError = new ValidationError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos",
                "Campos obrigatórios não foram preenchidos corretamente !", request.getRequestURI());

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            validationError.addError(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

}
