package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.persistance.TaxPersistance;

public interface TaxManager {

    void insertNewTax(Tax tax);

}
