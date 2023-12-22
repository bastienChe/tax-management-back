package com.bastienche.tax.manager.persistance;

import com.bastienche.tax.manager.domain.VatCredit;
import com.bastienche.tax.manager.domain.VatCreditCategory;
import com.bastienche.tax.manager.domain.exceptions.UnknownVatCreditCategoryException;
import com.bastienche.tax.manager.persistance.dao.VatCreditDao;
import com.bastienche.tax.manager.persistance.dao.VatCreditEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class VatCreditPersistanceImplTest {


    @Mock
    VatCreditDao vatCreditDao;

    @InjectMocks
    VatCreditPersistanceImpl vatCreditPersistance;

    @Test
    void createVatCreditTest() throws UnknownVatCreditCategoryException, IOException {
        LocalDate date = LocalDate.of(1992, 04, 23);
        byte[] pic = "Test String".getBytes();
        MockMultipartFile mockMultipartFile = new MockMultipartFile("tempFileName", pic);

        VatCredit vatCredit = new VatCredit(date, VatCreditCategory.ESSENCE, "explanation", 10, mockMultipartFile);
        vatCreditPersistance.create(vatCredit);
        Mockito.verify(vatCreditDao).save(VatCreditHelper.VatCreditEntityFrom(vatCredit));
    }

    @Test
    void getVatCreditIdTest() {
        VatCreditEntity vatCreditEntity = new VatCreditEntity();
        Optional<VatCreditEntity> vatCreditEntityReturnedByDao = Optional.of(vatCreditEntity);
        Mockito.doReturn(vatCreditEntityReturnedByDao).when(vatCreditDao).findById("5");

        VatCreditEntity sut = vatCreditPersistance.get("5");

        Mockito.verify(vatCreditDao, Mockito.times(2)).findById(Mockito.eq("5"));
        Assertions.assertEquals(vatCreditEntity, sut);
    }

    @Test
    void getVatCreditIdUnkonwnTest() {
        Optional<VatCreditEntity> vatCreditEntityReturnedByDao = Optional.empty();
        Mockito.doReturn(vatCreditEntityReturnedByDao).when(vatCreditDao).findById("5");

        VatCreditEntity sut = vatCreditPersistance.get("5");

        Assertions.assertNull(sut);
    }

    @Test
    void getVatCreditdTest() {
        vatCreditPersistance.get();
        Mockito.verify(vatCreditDao).findAll();
    }

    @Test
    void getWithDateFilterdTest() {
        vatCreditPersistance.getWithDateFilter(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-30"));
        Mockito.verify(vatCreditDao).findVatCreditBetween(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-30"));
    }

    @Test
    void removeExistingVatCreditdTest() {
        VatCreditEntity vatCreditEntity = new VatCreditEntity();
        Optional <VatCreditEntity> vatCreditEntityReturnedByDao = Optional.of(vatCreditEntity);

        Mockito.doReturn(vatCreditEntityReturnedByDao).when(vatCreditDao).findById("1");

        VatCreditEntity sut = vatCreditPersistance.remove("1");

        Mockito.verify(vatCreditDao).delete(Mockito.eq(vatCreditEntity));
        Assertions.assertEquals(vatCreditEntity, sut);
    }

    @Test
    void removeUnexistingVatCreditdTest() {
        Optional<VatCreditEntity> vatCreditEntityReturnedByDao = Optional.empty();
        Mockito.doReturn(vatCreditEntityReturnedByDao).when(vatCreditDao).findById("1");

        VatCreditEntity sut = vatCreditPersistance.remove("1");

        Mockito.verify(vatCreditDao, Mockito.never()).delete(Mockito.any());
        Assertions.assertNull(sut);
    }
}