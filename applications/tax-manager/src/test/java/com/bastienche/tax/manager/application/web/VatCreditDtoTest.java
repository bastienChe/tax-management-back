package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class VatCreditDtoTest {

    @Test
    void taxDtoTo() throws UnknownVatCreditCategoryException {
        LocalDateTime date = LocalDateTime.of(1992, 04, 23, 10, 00, 00);
        byte[] pic = {0,1,2};

        VatCreditDto vatCreditDto = new VatCreditDto(date, VatCreditCategoryDto.ESSENCE, "explanation", 10, pic);
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, pic);

        Assertions.assertEquals(vatCredit, VatCreditDto.VatCreditDtoTo(vatCreditDto));
    }
}