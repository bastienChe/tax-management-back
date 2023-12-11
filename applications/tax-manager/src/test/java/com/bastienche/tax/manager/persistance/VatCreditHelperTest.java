package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VatCreditHelperTest {

    @Test
    void taxEntityFromTax() {
        VatCredit vatCredit = new VatCredit();
        VatCreditEntity vatCreditEntity = new VatCreditEntity();
        Assertions.assertEquals(vatCreditEntity, VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }
}