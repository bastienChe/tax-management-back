package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VatCreditControllerTest {

    @Mock
    VatCreditManager vatCreditManager;

    @InjectMocks
    VatCreditController vatCreditController;

    @Test
    void insertNewTax() {
        VatCreditDto vatCreditDto = new VatCreditDto();
        vatCreditController.insert(vatCreditDto);
        Mockito.verify(vatCreditManager).insert(Mockito.eq(new VatCredit()));
    }
}