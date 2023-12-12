package com.bastienche.tax.manager.persistance.dao;

import com.bastienche.tax.manager.domain.VatCreditCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "VatCredit")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class VatCreditEntity {


    @Id
    @Column(columnDefinition = "number(10)", nullable = false)
    private long idVatCredit;

    @Column(columnDefinition = "Date", nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private VatCreditCategory category;

    @Column(columnDefinition = "varchar(50)")
    private String categoryExplanation;

    @Column(columnDefinition = "number(5)", nullable = false)
    private long price;

    @Column(columnDefinition = "blob", nullable = false)
    private byte[] picture;
}
