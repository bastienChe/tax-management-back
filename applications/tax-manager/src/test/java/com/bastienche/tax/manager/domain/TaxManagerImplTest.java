package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.persistance.TaxPersistance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaxManagerImplTest {

    @Mock
    TaxPersistance taxPersistance;

    @InjectMocks
    TaxManagerImpl taxManager;

    @Test
    void insertNewTax() {
        Tax tax = new Tax();
        taxManager.insertNewTax(tax);
        Mockito.verify(taxPersistance).createTax(tax);
    }
}