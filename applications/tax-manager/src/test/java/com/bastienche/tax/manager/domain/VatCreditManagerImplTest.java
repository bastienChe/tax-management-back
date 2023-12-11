package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.persistance.VatCreditPersistance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VatCreditManagerImplTest {

    @Mock
    VatCreditPersistance vatCreditPersistance;

    @InjectMocks
    VatCreditManagerImpl VatCreditManager;

    @Test
    void insertNewTax() {
        VatCredit vatCredit = new VatCredit();
        VatCreditManager.insert(vatCredit);
        Mockito.verify(vatCreditPersistance).create(vatCredit);
    }
}