package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.application.web.VatCreditCategoryDto;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VatCreditCategoryTest {

    @Test
    void vatCreditCategoryFromESSENCETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.ESSENCE, VatCreditCategory.from(VatCreditCategoryDto.ESSENCE));
    }
    @Test
    void vatCreditCategoryFromELECTRICITETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.ELECTRICITE, VatCreditCategory.from(VatCreditCategoryDto.ELECTRICITE));
    }
    @Test
    void vatCreditCategoryFromREPASTest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.REPAS, VatCreditCategory.from(VatCreditCategoryDto.REPAS));
    }
    @Test
    void vatCreditCategoryFromINTERNETTest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.INTERNET, VatCreditCategory.from(VatCreditCategoryDto.INTERNET));
    }
    @Test
    void vatCreditCategoryFromTELEPHONETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.TELEPHONE, VatCreditCategory.from(VatCreditCategoryDto.TELEPHONE));
    }
    @Test
    void vatCreditCategoryFromAUTRETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategory.AUTRE, VatCreditCategory.from(VatCreditCategoryDto.AUTRE));
    }

}