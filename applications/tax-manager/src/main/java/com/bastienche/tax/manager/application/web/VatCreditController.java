package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditManager;

public class VatCreditController {

    private VatCreditManager vatCreditManager;

    public VatCreditController(VatCreditManager vatCreditManager) {
        this.vatCreditManager = vatCreditManager;
    }

    public void insert(VatCreditDto vatCreditDto) {
        vatCreditManager.insert(VatCreditDto.VatCreditDtoTo(vatCreditDto));
    }

}
