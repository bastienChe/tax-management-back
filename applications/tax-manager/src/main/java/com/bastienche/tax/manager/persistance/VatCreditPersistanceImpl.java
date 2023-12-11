package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;

public class VatCreditPersistanceImpl implements VatCreditPersistance {

    VatCreditDao vatCreditDao;

    public VatCreditPersistanceImpl(VatCreditDao vatCreditDao) {
        this.vatCreditDao = vatCreditDao;
    }

    @Override
    public void create(VatCredit vatCredit) {
        vatCreditDao.save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

}
