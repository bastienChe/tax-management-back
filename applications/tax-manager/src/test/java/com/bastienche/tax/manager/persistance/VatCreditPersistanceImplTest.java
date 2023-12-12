package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class VatCreditPersistanceImplTest {


    @Mock
    VatCreditDao vatCreditDao;

    @InjectMocks
    VatCreditPersistanceImpl vatCreditPersistance;

    @Test
    void createVatCreditTest() throws UnknownVatCreditCategoryException {
        LocalDateTime date = LocalDateTime.of(1992, 04, 23, 10, 00, 00);
        byte[] pic = {0,1,2};
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, pic);
        vatCreditPersistance.create(vatCredit);
        Mockito.verify(vatCreditDao).save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

    @Test
    void getVatCreditTest() {
        vatCreditPersistance.get("5");
        Mockito.verify(vatCreditDao).findById(Mockito.eq("5"));
    }
}