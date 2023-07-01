package com.example.helicopter.repo;

import com.example.helicopter.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends JpaRepository<Medication, Long> {
    Medication findByArticul(String articul);
}
