package com.bastienche.tax.manager.domain;

import java.time.LocalDateTime;

public record VatCredit(LocalDateTime date, VatCreditCategory category, String categoryExplanation, long price, byte[] picture) {

}
