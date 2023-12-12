package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.application.web.VatCreditCategoryDto;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;

public enum VatCreditCategory {
    ESSENCE, ELECTRICITE, REPAS, INTERNET, TELEPHONE, AUTRE;

    public static VatCreditCategory from(VatCreditCategoryDto vatCreditCategoryDto) throws UnknownVatCreditCategoryException {
        switch (vatCreditCategoryDto) {
            case ESSENCE:
                return VatCreditCategory.ESSENCE;
            case ELECTRICITE:
                return VatCreditCategory.ELECTRICITE;
            case REPAS:
                return VatCreditCategory.REPAS;
            case INTERNET:
                return VatCreditCategory.INTERNET;
            case TELEPHONE:
                return VatCreditCategory.TELEPHONE;
            case AUTRE:
                return VatCreditCategory.AUTRE;
            default:
                throw new UnknownVatCreditCategoryException("Can't convert unknown VatCreditCategoryDto : "+ vatCreditCategoryDto.name());
        }
    }
}
