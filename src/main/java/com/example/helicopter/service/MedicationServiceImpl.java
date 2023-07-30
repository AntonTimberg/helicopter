package com.example.helicopter.service;

import com.example.helicopter.converter.MedicationConverter;
import com.example.helicopter.dto.MedicationDto;
import com.example.helicopter.entity.Medication;
import com.example.helicopter.repo.MedicationRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepo medicationRepo;
    private final MedicationConverter medicationConverter;

    @Override
    public MedicationDto createMedication(final Medication medication) {
        return medicationConverter.convert(medicationRepo.save(medication));
    }

    @Override
    public List<MedicationDto> getAll() {
        return medicationRepo.findAll().stream()
                .map(medicationConverter::convert)
                .toList();
    }

    @Override
    public MedicationDto getMedicationByArtucul(@NonNull final String articul) {
        return medicationConverter.convert(
                medicationRepo.findByArticul(articul)
                        .orElseThrow(() -> new RuntimeException("Medication not found"))
        );
    }

    @Override
    public void deleteMedicationByArticul(@NonNull final String articul) {
        var medication = medicationRepo.findByArticul(articul)
                .orElseThrow(() -> new RuntimeException("Medication not found"));

        medicationRepo.delete(medication);
    }

    @Override
    public MedicationDto updateMedication(Medication medication) {
        if (medicationRepo.existsById(medication.getId())) {
            return medicationConverter.convert(medicationRepo.save(medication));
        } else {
            throw new RuntimeException("Medication does not exist");
        }
    }
}
