package com.bastienche.tax.manager.domain.exceptions;

public class UnknownVatCreditCategoryException extends Exception {
    public UnknownVatCreditCategoryException(String message) {
        super(message);
    }
}
