package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record VatCreditDto(LocalDate date, VatCreditCategoryDto category, String categoryExplanation, long price, MultipartFile picture) {

    public static VatCredit VatCreditDtoTo(VatCreditDto vatCreditDto) throws UnknownVatCreditCategoryException {
        return new VatCredit(vatCreditDto.date, VatCreditCategory.from(vatCreditDto.category), vatCreditDto.categoryExplanation, vatCreditDto.price, vatCreditDto.picture);
    }

}
