package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditManager;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;

public class VatCreditController {

    private VatCreditManager vatCreditManager;

    public VatCreditController(VatCreditManager vatCreditManager) {
        this.vatCreditManager = vatCreditManager;
    }

    public void insert(VatCreditDto vatCreditDto) throws UnknownVatCreditCategoryException {
        vatCreditManager.insert(VatCreditDto.VatCreditDtoTo(vatCreditDto));
    }

}
