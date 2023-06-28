package com.example.helicopter.repo;

import com.example.helicopter.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends JpaRepository<Drone, Long> {
    Drone findBySerialNumber(String serialNumber);
}
