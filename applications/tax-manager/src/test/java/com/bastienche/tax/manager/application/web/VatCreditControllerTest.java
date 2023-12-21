package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.VatCreditManager;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
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
class VatCreditControllerTest {

    @Mock
    VatCreditManager vatCreditManager;

    @InjectMocks
    VatCreditController vatCreditController;

    @Test
    void insertNewVatCreditTest() throws UnknownVatCreditCategoryException, IOException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = {0,1,2};
        MockMultipartFile mockMultipartFile = new MockMultipartFile("tempFileName", pic);
        long price = 10l;
        String categoryExplanation = "explanation";

        vatCreditController.insert(price, "1992-04-23", "ESSENCE", categoryExplanation, mockMultipartFile);

        Mockito.verify(vatCreditManager).insert(Mockito.eq(new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, mockMultipartFile)));
    }

    @Test
    void getVatCreditIdTest() throws UnknownVatCreditCategoryException {
        vatCreditController.getId("5");
        Mockito.verify(vatCreditManager).get(Mockito.eq("5"));
    }

    @Test
    void getVatCreditsTest() throws UnknownVatCreditCategoryException {
        vatCreditController.get();
        Mockito.verify(vatCreditManager).get();
    }

    @Test
    void getVatCreditWithDateFilterTest() throws UnknownVatCreditCategoryException {
        vatCreditController.getVatCreditWithDateFilter("2023-10-01", "2023-10-30");
        Mockito.verify(vatCreditManager).getWithDateFilter(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-30"));
    }
}