package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.Tax;
import com.bastienche.tax.manager.persistance.dao.TaxEntity;

public class TaxHelper {

    public static TaxEntity TaxEntityFromTax(Tax tax) {
        return new TaxEntity();
    }

}
