package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class VatCreditDto {

    private LocalDateTime date;

    private VatCreditCategoryDto category;

    private String categoryExplanation;

    private long price;

    private byte[] picture;

    public static VatCredit VatCreditDtoTo(VatCreditDto vatCreditDto) throws UnknownVatCreditCategoryException {
        return new VatCredit(vatCreditDto.getDate(), VatCreditCategory.from(vatCreditDto.getCategory()), vatCreditDto.getCategoryExplanation(), vatCreditDto.getPrice(), vatCreditDto.getPicture());
    }

}
