package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.Tax;
import com.bastienche.tax.manager.persistance.dao.TaxEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxHelperTest {

    @Test
    void taxEntityFromTax() {
        Tax tax = new Tax();
        TaxEntity taxEntity = new TaxEntity();
        Assertions.assertEquals(taxEntity, TaxHelper.TaxEntityFromTax(tax));
    }
}