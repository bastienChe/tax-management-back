package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.Tax;
import com.bastienche.tax.manager.persistance.dao.TaxDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxPersistanceImplTest {


    @Mock
    TaxDao taxDao;

    @InjectMocks
    TaxPersistanceImpl taxPersistance;

    @Test
    void createTax() {
        Tax tax = new Tax();
        taxPersistance.createTax(tax);
        Mockito.verify(taxDao).save(TaxHelper.TaxEntityFromTax(tax));
    }
}