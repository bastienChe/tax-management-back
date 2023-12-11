package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;

public interface VatCreditPersistance {
    void create(VatCredit vatCredit);
}
