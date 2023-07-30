package com.example.helicopter.service;

import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;

import java.util.List;

public interface DroneService {
    DroneDto createDrone(Drone drone);

    List<DroneDto> getAll();

    DroneDto getDroneBySerial(String serialNumber);

    void deleteDroneBySerial(String serialNumber);

    DroneDto updateDrone(Drone drone);
}
