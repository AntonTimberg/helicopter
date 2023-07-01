package com.example.helicopter.service;

import com.example.helicopter.entity.Drone;

import java.util.List;

public interface DroneService {
    Drone createDrone(Drone drone);
    List<Drone> getAll();
    Drone getDroneBySerial(String serialNumber);
    void deleteDroneBySerial(String serialNumber);
    Drone updateDrone(Drone drone);
}
