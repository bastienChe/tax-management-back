package com.bastienche.tax.manager.persistance.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VatCreditDao extends CrudRepository<VatCreditEntity, String> {
}
