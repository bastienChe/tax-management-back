package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

class VatCreditDtoTest {

    @Test
    void VatCreditDtoToTest() throws UnknownVatCreditCategoryException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = "Test String".getBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("tempFileName", pic);

        VatCreditDto vatCreditDto = new VatCreditDto(date, VatCreditCategoryDto.ESSENCE, "explanation", 10, multipartFile);
        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, multipartFile);

        Assertions.assertEquals(vatCredit, VatCreditDto.VatCreditDtoTo(vatCreditDto));
    }
}