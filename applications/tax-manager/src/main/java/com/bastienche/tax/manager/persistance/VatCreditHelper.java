package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditCategoryEntity;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class VatCreditHelper {

    public static VatCreditEntity VatCreditEntityFrom(VatCredit vatCredit) throws UnknownVatCreditCategoryException {
        return new VatCreditEntity(0l, vatCredit.date(), VatCreditCategoryEntity.from(vatCredit.category()), vatCredit.categoryExplanation(), vatCredit.price(), vatCredit.picture());
    }

}
