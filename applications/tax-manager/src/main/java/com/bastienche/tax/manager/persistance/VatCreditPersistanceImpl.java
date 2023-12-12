package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VatCreditPersistanceImpl implements VatCreditPersistance {

    VatCreditDao vatCreditDao;

    public VatCreditPersistanceImpl(VatCreditDao vatCreditDao) {
        this.vatCreditDao = vatCreditDao;
    }

    @Override
    public VatCreditEntity create(VatCredit vatCredit) throws UnknownVatCreditCategoryException {
       return vatCreditDao.save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

    @Override
    public VatCreditEntity get(String id) {
        return vatCreditDao.findById(id).isPresent() ? vatCreditDao.findById(id).get() : null;
    }

}
