package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.persistance.TaxPersistance;

public class TaxManagerImpl {

    TaxPersistance taxPersistance;

    public TaxManagerImpl(TaxPersistance taxPersistance) {
     this.taxPersistance = taxPersistance;
    }

    public void insertNewTax(Tax tax) {
        taxPersistance.createTax(tax);
    }


}
