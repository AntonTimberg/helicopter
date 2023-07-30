package com.example.helicopter.service;

import com.example.helicopter.converter.DroneConverter;
import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;
import com.example.helicopter.repo.DroneRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {
    private final DroneRepo droneRepo;
    private final DroneConverter droneConverter;

    @Override
    public DroneDto createDrone(final Drone drone) {
        return droneConverter.convert(
                droneRepo.save(drone)
        );
    }

    @Override
    public List<DroneDto> getAll() {
        return droneRepo.findAll().stream()
                .map(droneConverter::convert)
                .toList();
    }

    @Override
    public DroneDto getDroneBySerial(@NonNull final String serialNumber) {
        return droneConverter.convert(droneRepo.findBySerialNumber(serialNumber));
    }

    @Override
    public void deleteDroneBySerial(@NonNull final String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        if (drone != null) {
            droneRepo.delete(drone);
        }
    }

    @Override
    public DroneDto updateDrone(final Drone drone) {
        if (droneRepo.existsById(drone.getId())) {
            return droneConverter.convert(droneRepo.save(drone));
        } else {
            throw new RuntimeException("Drone does not exist");
        }
    }
}
