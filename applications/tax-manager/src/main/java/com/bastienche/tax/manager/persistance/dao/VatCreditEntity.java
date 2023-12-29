package com.bastienche.tax.manager.persistance.dao;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(columnDefinition = "INTEGER", nullable = false)
    private long idVatCredit;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private VatCreditCategoryEntity category;

    @Column(columnDefinition = "VARCHAR(50)")
    private String categoryExplanation;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private long price;

    @Column(columnDefinition = "BYTEA", nullable = false)
    private byte[] picture;
}
