package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;

import java.time.LocalDateTime;

public record VatCreditDto(LocalDateTime date, VatCreditCategoryDto category, String categoryExplanation, long price, byte[] picture) {

    public static VatCredit VatCreditDtoTo(VatCreditDto vatCreditDto) throws UnknownVatCreditCategoryException {
        return new VatCredit(vatCreditDto.date, VatCreditCategory.from(vatCreditDto.category), vatCreditDto.categoryExplanation, vatCreditDto.price, vatCreditDto.picture);
    }

}
