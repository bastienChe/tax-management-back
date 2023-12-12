package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditCategoryEntity;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class VatCreditHelperTest {

    @Test
    void VatCreditEntityFromTest() throws UnknownVatCreditCategoryException {
        LocalDateTime date = LocalDateTime.of(1992, 04, 23, 10, 00, 00);
        byte[] pic = {0,1,2};
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, pic);

        VatCreditEntity vatCreditEntity = new VatCreditEntity(0L, date, VatCreditCategoryEntity.ESSENCE, "explanation", 10, pic);

        Assertions.assertEquals(vatCreditEntity, VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }
}