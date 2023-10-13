package com.roerdev.arqhexagonalmodular.product.rest.advice;

import com.roerdev.arqhexagonalmodular.product.model.exceptions.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> handleEmptyInput(ProductException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.CONFLICT);
    }
}
