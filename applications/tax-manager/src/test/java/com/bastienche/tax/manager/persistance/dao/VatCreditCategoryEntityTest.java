package com.bastienche.tax.manager.persistance.dao;

import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VatCreditCategoryEntityTest {

    @Test
    void VatCreditCategoryEntityFromESSENCETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.ESSENCE, VatCreditCategoryEntity.from(VatCreditCategory.ESSENCE));
    }
    @Test
    void VatCreditCategoryEntityFromELECTRICITETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.ELECTRICITE, VatCreditCategoryEntity.from(VatCreditCategory.ELECTRICITE));
    }
    @Test
    void VatCreditCategoryEntityFromREPASTest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.REPAS, VatCreditCategoryEntity.from(VatCreditCategory.REPAS));
    }
    @Test
    void VatCreditCategoryEntityFromINTERNETTest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.INTERNET, VatCreditCategoryEntity.from(VatCreditCategory.INTERNET));
    }
    @Test
    void VatCreditCategoryEntityFromTELEPHONETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.TELEPHONE, VatCreditCategoryEntity.from(VatCreditCategory.TELEPHONE));
    }
    @Test
    void VatCreditCategoryEntityFromAUTRETest() throws UnknownVatCreditCategoryException {
        Assertions.assertEquals(VatCreditCategoryEntity.AUTRE, VatCreditCategoryEntity.from(VatCreditCategory.AUTRE));
    }
}