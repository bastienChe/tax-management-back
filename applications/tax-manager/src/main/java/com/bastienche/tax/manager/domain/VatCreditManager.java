package com.bastienche.tax.manager.domain;

import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface VatCreditManager {

    VatCreditEntity insert(VatCredit vatCredit) throws UnknownVatCreditCategoryException;

    VatCreditEntity get(String id) throws UnknownVatCreditCategoryException;

}
