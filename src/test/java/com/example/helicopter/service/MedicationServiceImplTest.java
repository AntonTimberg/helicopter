package com.example.helicopter.service;

import com.example.helicopter.entity.Medication;
import com.example.helicopter.repo.MedicationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MedicationServiceImplTest {
    @InjectMocks
    private MedicationServiceImpl medicationService;
    @Mock
    private MedicationRepo medicationRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createMedicationTest() {
        var medication = mock(Medication.class);
        var savedMedication = mock(Medication.class);
        when(medicationRepo.save(medication)).thenReturn(savedMedication);

        var actual = medicationService.createMedication(medication);

        assertEquals(savedMedication, actual);
        verify(medicationRepo).save(medication);
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void getAllTest() {
        var medication = mock(Medication.class);
        var medicationList = List.of(medication);
        when(medicationRepo.findAll()).thenReturn(medicationList);

        var actual = medicationService.getAll();

        assertEquals(medicationList, actual);
        assertEquals(medication, actual.get(0));
        verify(medicationRepo).findAll();
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void getMedicationByArticulTest() {
        String articul = "123";
        var medication = mock(Medication.class);
        when(medicationRepo.findByArticul(articul)).thenReturn(medication);

        var actual = medicationService.getMedicationByArtucul(articul);

        assertEquals(medication, actual);
        verify(medicationRepo).findByArticul(articul);
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void deleteMedicationByArticulWhenMedicationIsFoundTest() {
        String articul = "123";
        var medication = mock(Medication.class);
        when(medicationRepo.findByArticul(articul)).thenReturn(medication);

        medicationService.deleteMedicationByArticul(articul);

        verify(medicationRepo).findByArticul(articul);
        verify(medicationRepo).delete(medication);
        verifyNoMoreInteractions(medicationRepo);
    }

    @Test
    void deleteMedicationByArticulWhenMedicationIsNullTest() {
        String articul = "123";
        when(medicationRepo.findByArticul(articul)).thenReturn(null);

        medicationService.deleteMedicationByArticul(articul);

        verify(medicationRepo).findByArticul(articul);
        verifyNoMoreInteractions(medicationRepo);
    }
}
