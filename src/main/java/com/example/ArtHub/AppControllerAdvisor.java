package com.example.ArtHub;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AppControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        for (ObjectError err : e.getAllErrors()) {
            errors.add(err.getDefaultMessage());
        }
        AppError errorResponse = new AppValidationError(errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppServiceExeption.class)
    public ResponseEntity<AppError> handleAppServiceException(AppServiceExeption e, HttpServletRequest request) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}