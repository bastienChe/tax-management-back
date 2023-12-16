package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditCategoryEntity;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

class VatCreditHelperTest {

    @Test
    void VatCreditEntityFromTest() throws UnknownVatCreditCategoryException, IOException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = "Test String".getBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("tempFile", pic);
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, multipartFile);

        VatCreditEntity vatCreditEntity = new VatCreditEntity(0L, date, VatCreditCategoryEntity.ESSENCE, "explanation", 10, pic);

        Assertions.assertEquals(vatCreditEntity, VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }
}