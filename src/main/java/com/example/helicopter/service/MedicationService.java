package com.example.helicopter.service;

import com.example.helicopter.entity.Medication;

import java.util.List;

public interface MedicationService {
    Medication createMedication(Medication medication);

    List<Medication> getAll();

    Medication getMedicationByArtucul(String articul);

    void deleteMedicationByArticul(String articul);
}
