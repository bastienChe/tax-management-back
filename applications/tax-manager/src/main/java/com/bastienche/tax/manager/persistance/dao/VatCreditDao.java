package com.bastienche.tax.manager.persistance.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VatCreditDao extends CrudRepository<VatCreditEntity, String> {
    @Query("SELECT v from VatCreditEntity v WHERE v.date BETWEEN :dateStart AND :dateEnd")
    Iterable<VatCreditEntity> findVatCreditBetween(@Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);
}
