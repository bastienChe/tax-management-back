package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.Tax;
import com.bastienche.tax.manager.domain.TaxManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaxControllerTest {

    @Mock
    TaxManager taxManager;

    @InjectMocks
    TaxController taxController;

    @Test
    void insertNewTax() {
        TaxDto taxDto = new TaxDto();
        taxController.insertNewTax(taxDto);
        Mockito.verify(taxManager).insertNewTax(Mockito.eq(new Tax()));
    }
}