package com.bastienche.tax.manager.domain;

import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class VatCredit {

    private LocalDateTime date;

    private VatCreditCategory category;

    private String categoryExplanation;

    private long price;

    private byte[] picture;
}
