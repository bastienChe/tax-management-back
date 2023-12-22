package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface VatCreditPersistance {
    VatCreditEntity create(VatCredit vatCredit) throws UnknownVatCreditCategoryException, IOException;

    VatCreditEntity get(String id);

    List<VatCreditEntity> get();

    List<VatCreditEntity> getWithDateFilter(LocalDate dateStart, LocalDate dateEnd);

    VatCreditEntity remove(String id);
}
