package com.bastienche.tax.manager.persistance.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatCreditDao extends CrudRepository<VatCreditEntity, String> {


}
