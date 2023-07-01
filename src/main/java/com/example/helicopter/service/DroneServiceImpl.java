package com.example.helicopter.service;

import com.example.helicopter.entity.Drone;
import com.example.helicopter.repo.DroneRepo;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    private final DroneRepo droneRepo;

    public DroneServiceImpl(@NonNull final DroneRepo droneRepo){
        this.droneRepo = droneRepo;
    }
    @Override
    public Drone createDrone(@NonNull final Drone drone) {
        return droneRepo.save(drone);
    }

    @Override
    public List<Drone> getAll() {
        return droneRepo.findAll();
    }

    @Override
    public Drone getDroneBySerial(@NonNull final String serialNumber){
        return droneRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public void deleteDroneBySerial(@NonNull final String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        if (drone != null){
            droneRepo.delete(drone);
        }
    }

    @Override
    public Drone updateDrone(@NonNull final Drone drone) {
        return droneRepo.save(drone);
    }
}
