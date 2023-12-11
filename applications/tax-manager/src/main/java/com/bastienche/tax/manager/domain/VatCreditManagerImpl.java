package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.persistance.VatCreditPersistance;

public class VatCreditManagerImpl implements VatCreditManager {

    VatCreditPersistance vatCreditPersistance;

    public VatCreditManagerImpl(VatCreditPersistance vatCreditPersistance) {
     this.vatCreditPersistance = vatCreditPersistance;
    }

    public void insert(VatCredit vatCredit) {
        vatCreditPersistance.create(vatCredit);
    }


}
