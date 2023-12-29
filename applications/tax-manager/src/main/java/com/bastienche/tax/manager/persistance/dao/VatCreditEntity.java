package com.bastienche.tax.manager.persistance.dao;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "vatcredit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VatCreditEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "number(10)", nullable = false)
    private long idVatCredit;

    @Column(columnDefinition = "Date", nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private VatCreditCategoryEntity category;

    @Column(columnDefinition = "varchar(50)")
    private String categoryExplanation;

    @Column(columnDefinition = "number(5)", nullable = false)
    private long price;

    @Column(columnDefinition = "blob", nullable = false)
    private byte[] picture;
}
