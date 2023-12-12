package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.VatCreditManager;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class VatCreditControllerTest {

    @Mock
    VatCreditManager vatCreditManager;

    @InjectMocks
    VatCreditController vatCreditController;

    @Test
    void insertNewTax() throws UnknownVatCreditCategoryException {
        LocalDateTime date = LocalDateTime.of(1992, 04, 23, 10, 00, 00);
        byte[] pic = {0,1,2};
        VatCreditDto vatCreditDto = new VatCreditDto(date, VatCreditCategoryDto.ESSENCE, "explanation", 10, pic);
        vatCreditController.insert(vatCreditDto);
        Mockito.verify(vatCreditManager).insert(Mockito.eq(new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, pic)));
    }
}