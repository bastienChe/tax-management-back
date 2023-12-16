package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.VatCreditPersistance;
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
class VatCreditManagerImplTest {

    @Mock
    VatCreditPersistance vatCreditPersistance;

    @InjectMocks
    VatCreditManagerImpl vatCreditManager;

    @Test
    void insertNewVatCreditTest() throws UnknownVatCreditCategoryException, IOException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = "Test String".getBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("tempName", pic);
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, multipartFile);
        vatCreditManager.insert(vatCredit);
        Mockito.verify(vatCreditPersistance).create(vatCredit);
    }

    @Test
    void getNewVatCreditTest() {
        vatCreditManager.get("5");
        Mockito.verify(vatCreditPersistance).get(Mockito.eq("5"));
    }
}