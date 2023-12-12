package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface VatCreditPersistance {
    VatCreditEntity create(VatCredit vatCredit) throws UnknownVatCreditCategoryException;

    VatCreditEntity get(String id);
}
