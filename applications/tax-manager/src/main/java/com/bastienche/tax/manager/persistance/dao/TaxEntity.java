package com.bastienche.tax.manager.persistance.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Tax")
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Getter
public class TaxEntity {


    @Id
    @Column(columnDefinition = "number(10)", nullable = false)
    private long idCrem;

}
