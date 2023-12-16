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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class VatCreditPersistanceImplTest {


    @Mock
    VatCreditDao vatCreditDao;

    @InjectMocks
    VatCreditPersistanceImpl vatCreditPersistance;

    @Test
    void createVatCreditTest() throws UnknownVatCreditCategoryException, IOException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = "Test String".getBytes();
        MockMultipartFile mockMultipartFile = new MockMultipartFile("tempFileName", pic);

        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, mockMultipartFile);
        vatCreditPersistance.create(vatCredit);
        Mockito.verify(vatCreditDao).save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

    @Test
    void getVatCreditTest() {
        vatCreditPersistance.get("5");
        Mockito.verify(vatCreditDao).findById(Mockito.eq("5"));
    }
}