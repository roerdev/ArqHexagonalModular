package com.roerdev.arqhexagonalmodular.product.model.exceptions;

public class ProductException extends RuntimeException{

    private String errorMessage;

    public ProductException() {
        super();
    }

    public ProductException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
