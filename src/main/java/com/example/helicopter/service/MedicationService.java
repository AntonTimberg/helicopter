package com.example.helicopter.service;

import com.example.helicopter.dto.MedicationDto;
import com.example.helicopter.entity.Medication;

import java.util.List;

public interface MedicationService {
    MedicationDto createMedication(Medication medication);

    List<MedicationDto> getAll();

    MedicationDto getMedicationByArtucul(String articul);

    void deleteMedicationByArticul(String articul);

    MedicationDto updateMedication(Medication medication);
}
