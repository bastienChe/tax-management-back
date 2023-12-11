package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VatCreditDtoTest {

    @Test
    void taxDtoTo() {
        VatCreditDto vatCreditDto = new VatCreditDto();
        VatCredit vatCredit = new VatCredit();
        Assertions.assertEquals(vatCredit, VatCreditDto.VatCreditDtoTo(vatCreditDto));
    }
}