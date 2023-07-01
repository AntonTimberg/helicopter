package com.example.helicopter.service;

import com.example.helicopter.entity.Medication;
import com.example.helicopter.repo.MedicationRepo;
import lombok.NonNull;

import java.util.List;

public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepo medicationRepo;

    public MedicationServiceImpl(MedicationRepo medicationRepo) {
        this.medicationRepo = medicationRepo;
    }

    @Override
    public Medication createMedication(@NonNull final Medication medication) {
        return medicationRepo.save(medication);
    }

    @Override
    public List<Medication> getAll() {
        return medicationRepo.findAll();
    }

    @Override
    public Medication getMedicationByArtucul(@NonNull final String articul) {
        return medicationRepo.findByArticul(articul);
    }

    @Override
    public void deleteMedicationByArticul(@NonNull final String articul) {
        Medication medication = medicationRepo.findByArticul(articul);
        if (medication != null) {
            medicationRepo.delete(medication);
        }
    }
}
