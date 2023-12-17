package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface VatCreditManager {

    VatCreditEntity insert(VatCredit vatCredit) throws UnknownVatCreditCategoryException, IOException;

    VatCreditEntity get(String id) throws UnknownVatCreditCategoryException;

    List<VatCreditEntity> get() throws UnknownVatCreditCategoryException;

}
