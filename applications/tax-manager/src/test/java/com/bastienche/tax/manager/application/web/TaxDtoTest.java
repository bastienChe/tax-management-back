package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxDtoTest {

    @Test
    void taxDtoTo() {
        TaxDto taxDto = new TaxDto();
        Tax tax = new Tax();
        Assertions.assertEquals(tax, TaxDto.taxDtoTo(taxDto));
    }
}