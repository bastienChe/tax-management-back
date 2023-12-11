package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.Tax;

public class TaxDto {

    public static Tax taxDtoTo(TaxDto taxDto) {
        return new Tax();
    }

}
