package com.bastienche.tax.manager.application.web;

import com.bastienche.tax.manager.domain.VatCreditManager;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/vat-credit")
@Slf4j
public class VatCreditController {

    private VatCreditManager vatCreditManager;

    public VatCreditController(VatCreditManager vatCreditManager) {
        this.vatCreditManager = vatCreditManager;
    }

    @PostMapping
    public ResponseEntity<VatCreditEntity> insert(@RequestParam("price") long price,
                                                  @RequestParam("date") String date,
                                                  @RequestParam("category") String category,
                                                  @RequestParam("categoryExplanation") String categoryExplanation,
                                                  @RequestParam("file") MultipartFile file) throws UnknownVatCreditCategoryException, IOException {
        VatCreditDto vatCreditDto = new VatCreditDto(LocalDate.parse(date), VatCreditCategoryDto.valueOf(category), categoryExplanation, price, file);
        VatCreditEntity vatCreditEntity = vatCreditManager.insert(VatCreditDto.VatCreditDtoTo(vatCreditDto));
        return new ResponseEntity<>(vatCreditEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VatCreditEntity> getId(@PathVariable String id) throws UnknownVatCreditCategoryException {
        VatCreditEntity vatCreditEntity = vatCreditManager.get(id);
        return vatCreditEntity != null ?
                new ResponseEntity<>(vatCreditEntity, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<VatCreditEntity>> get() throws UnknownVatCreditCategoryException {
        List<VatCreditEntity> vatCreditEntity = vatCreditManager.get();
        return vatCreditEntity != null ?
                new ResponseEntity<>(vatCreditEntity, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/date-between")
    public ResponseEntity<List<VatCreditEntity>> getVatCreditWithDateFilter(@RequestParam(name = "dateStart") String dateStart,
                                                                            @RequestParam(name = "dateEnd") String dateEnd) {
        List<VatCreditEntity> vatCreditEntity = vatCreditManager.getWithDateFilter(LocalDate.parse(dateStart), LocalDate.parse(dateEnd));
        return vatCreditEntity != null ?
                new ResponseEntity<>(vatCreditEntity, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VatCreditEntity> removeVatCredit(@PathVariable String id) {
        VatCreditEntity vatCreditEntity = vatCreditManager.remove(id);
        return vatCreditEntity != null ?
                new ResponseEntity<>(vatCreditEntity, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
