package com.example.helicopter.service;

import com.example.helicopter.converter.MedicationConverter;
import com.example.helicopter.dto.MedicationDto;
import com.example.helicopter.entity.Medication;
import com.example.helicopter.repo.MedicationRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class MedicationServiceImplTest {
    @InjectMocks
    private MedicationServiceImpl medicationService;
    @Mock
    private MedicationRepo medicationRepo;

    @Spy
    private MedicationConverter conversionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createMedicationTest() {
        var medication = mock(Medication.class);
        var convertedMedication = mock(MedicationDto.class);

        when(medicationRepo.save(medication)).thenReturn(medication);
        when(conversionService.convert(medication)).thenReturn(convertedMedication);

        var actual = medicationService.createMedication(medication);

        assertEquals(actual, convertedMedication);

        verify(medicationRepo).save(medication);
        verify(conversionService).convert(medication);
        verifyNoMoreInteractions(medicationRepo, conversionService);
    }

    @Test
    void getAllTest() {
        var medication = mock(Medication.class);
        var convertedMedication = mock(MedicationDto.class);
        var medicationList = List.of(medication);
        var convertedMedicationList = List.of(convertedMedication);

        when(medicationRepo.findAll()).thenReturn(medicationList);
        when(conversionService.convert(medication)).thenReturn(convertedMedication);

        var actual = medicationService.getAll();

        assertEquals(actual, convertedMedicationList);
        verify(medicationRepo).findAll();
        verify(conversionService).convert(medication);
        verifyNoMoreInteractions(medicationRepo, conversionService);
    }

    @Test
    void getMedicationByArticulTest() {
        var articul = "123";
        var medication = mock(Medication.class);
        var medicationOptional = Optional.of(medication);
        var convertedMedication = mock(MedicationDto.class);

        when(medicationRepo.findByArticul(articul)).thenReturn(medicationOptional);
        when(conversionService.convert(medication)).thenReturn(convertedMedication);

        var actual = medicationService.getMedicationByArtucul(articul);

        assertEquals(convertedMedication, actual);

        verify(medicationRepo).findByArticul(articul);
        verify(conversionService).convert(medication);
        verifyNoMoreInteractions(medicationRepo, conversionService);
    }

    @Test
    void deleteMedicationByArticulWhenMedicationIsFoundTest() {
        String articul = "123";
        var medication = mock(Medication.class);
        var medicationOptional = Optional.of(medication);
        when(medicationRepo.findByArticul(articul)).thenReturn(medicationOptional);

        medicationService.deleteMedicationByArticul(articul);

        verify(medicationRepo).findByArticul(articul);
        verify(medicationRepo).delete(medication);
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void deleteMedicationByArticulWhenMedicationIsNullTest() {
        String articul = "123";
        when(medicationRepo.findByArticul(articul)).thenReturn(Optional.empty());

        var thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            medicationService.deleteMedicationByArticul(articul);
        });

        Assertions.assertEquals("Medication not found", thrown.getMessage());

        verify(medicationRepo).findByArticul(articul);
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void updateMedicationTest() {
        var medication = mock(Medication.class);
        var savedMedication = mock(Medication.class);
        var convertedMedication = mock(MedicationDto.class);

        when(medicationRepo.save(medication)).thenReturn(savedMedication);
        when(conversionService.convert(savedMedication)).thenReturn(convertedMedication);

        var actual = conversionService.convert(medicationRepo.save(medication));

        assertEquals(convertedMedication, actual);
        verify(medicationRepo).save(medication);
        verify(conversionService).convert(savedMedication);
        verifyNoMoreInteractions(medicationRepo);
        verifyNoMoreInteractions(conversionService);
    }
}
