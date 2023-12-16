package com.bastienche.tax.manager.domain;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record VatCredit(LocalDate date, VatCreditCategory category, String categoryExplanation, long price, MultipartFile picture) {

}
