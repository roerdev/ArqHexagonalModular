package com.roerdev.arqhexagonalmodular.stock.model.exceptions;

public class StockException extends RuntimeException{

    private String errorMessage;

    public StockException() {
        super();
    }

    public StockException(String errorMessage) {
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
