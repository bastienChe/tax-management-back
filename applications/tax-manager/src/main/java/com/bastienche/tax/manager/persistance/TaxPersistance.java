package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.Tax;

public interface TaxPersistance {
    void createTax(Tax tax);
}
