package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.VatCreditPersistance;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VatCreditManagerImpl implements VatCreditManager {

    VatCreditPersistance vatCreditPersistance;

    public VatCreditManagerImpl(VatCreditPersistance vatCreditPersistance) {
     this.vatCreditPersistance = vatCreditPersistance;
    }

    public VatCreditEntity insert(VatCredit vatCredit) throws UnknownVatCreditCategoryException {
        return vatCreditPersistance.create(vatCredit);
    }

    @Override
    public VatCreditEntity get(String id) {
        return vatCreditPersistance.get(id);
    }


}
