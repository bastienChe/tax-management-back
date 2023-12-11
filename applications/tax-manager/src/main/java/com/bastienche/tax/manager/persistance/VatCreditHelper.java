package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;

public class VatCreditHelper {

    public static VatCreditEntity VatCreditEntityFrom(VatCredit vatCredit) {
        return new VatCreditEntity();
    }

}
