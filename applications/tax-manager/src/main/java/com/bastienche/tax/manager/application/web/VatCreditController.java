package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditManager;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vat-credit")
@Slf4j
public class VatCreditController {

    private VatCreditManager vatCreditManager;

    public VatCreditController(VatCreditManager vatCreditManager) {
        this.vatCreditManager = vatCreditManager;
    }

    @PostMapping
    public ResponseEntity<VatCreditEntity> insert(VatCreditDto vatCreditDto) throws UnknownVatCreditCategoryException {
        VatCreditEntity vatCreditEntity = vatCreditManager.insert(VatCreditDto.VatCreditDtoTo(vatCreditDto));
        return new ResponseEntity<>(vatCreditEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VatCreditEntity> get(@PathVariable String id) throws UnknownVatCreditCategoryException {
        VatCreditEntity vatCreditEntity = vatCreditManager.get(id);
        return vatCreditEntity != null ?
                new ResponseEntity<>(vatCreditEntity, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND) ;
    }

}
