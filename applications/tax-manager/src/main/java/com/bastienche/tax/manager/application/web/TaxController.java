package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.TaxManager;

public class TaxController {

    private TaxManager taxManager;

    public TaxController(TaxManager taxManager) {
        this.taxManager = taxManager;
    }

    public void insertNewTax(TaxDto taxDto) {
        taxManager.insertNewTax(TaxDto.taxDtoTo(taxDto));
    }

}
