package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.Tax;
import com.bastienche.tax.manager.persistance.dao.TaxDao;

public class TaxPersistanceImpl implements TaxPersistance{

    TaxDao taxDao;

    @Override
    public void createTax(Tax tax) {
        taxDao.save(TaxHelper.TaxEntityFromTax(tax));
    }

}
