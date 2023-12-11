package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VatCreditPersistanceImplTest {


    @Mock
    VatCreditDao vatCreditDao;

    @InjectMocks
    VatCreditPersistanceImpl taxPersistance;

    @Test
    void createTax() {
        VatCredit vatCredit = new VatCredit();
        taxPersistance.create(vatCredit);
        Mockito.verify(vatCreditDao).save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }
}