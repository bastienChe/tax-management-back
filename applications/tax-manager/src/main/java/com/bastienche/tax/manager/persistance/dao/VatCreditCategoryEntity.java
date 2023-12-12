package com.bastienche.tax.manager.persistance.dao;

import com.bastienche.tax.manager.application.web.VatCreditCategoryDto;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;

public enum VatCreditCategoryEntity {
    ESSENCE, ELECTRICITE, REPAS, INTERNET, TELEPHONE, AUTRE;

    public static VatCreditCategoryEntity from(VatCreditCategory vatCreditCategory) throws UnknownVatCreditCategoryException {
        switch (vatCreditCategory) {
            case ESSENCE:
                return VatCreditCategoryEntity.ESSENCE;
            case ELECTRICITE:
                return VatCreditCategoryEntity.ELECTRICITE;
            case REPAS:
                return VatCreditCategoryEntity.REPAS;
            case INTERNET:
                return VatCreditCategoryEntity.INTERNET;
            case TELEPHONE:
                return VatCreditCategoryEntity.TELEPHONE;
            case AUTRE:
                return VatCreditCategoryEntity.AUTRE;
            default:
                throw new UnknownVatCreditCategoryException("Can't convert unknown VatCreditCategoryDto : "+ vatCreditCategory.name());
        }
    }
}
