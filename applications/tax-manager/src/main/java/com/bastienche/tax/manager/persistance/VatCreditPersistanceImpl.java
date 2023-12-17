package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class VatCreditPersistanceImpl implements VatCreditPersistance {

    VatCreditDao vatCreditDao;

    public VatCreditPersistanceImpl(VatCreditDao vatCreditDao) {
        this.vatCreditDao = vatCreditDao;
    }

    @Override
    public VatCreditEntity create(VatCredit vatCredit) throws UnknownVatCreditCategoryException, IOException {
       return vatCreditDao.save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

    @Override
    public VatCreditEntity get(String id) {
        return vatCreditDao.findById(id).isPresent() ? vatCreditDao.findById(id).get() : null;
    }

    @Override
    public List<VatCreditEntity> get() {
        Iterable<VatCreditEntity> vatCreditEntities = vatCreditDao.findAll();
        return StreamSupport
                .stream(vatCreditEntities.spliterator(), false)
                .collect(Collectors.toList());
    }

}
