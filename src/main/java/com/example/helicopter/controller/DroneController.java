package com.example.helicopter.controller;

import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;
import com.example.helicopter.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drone")
public class DroneController {
    private final DroneService droneService;

    @RequestMapping("/getAll")
    public List<DroneDto> getAllDrones() {
        return droneService.getAll();
    }

    @PostMapping("/create")
    public DroneDto createDrone(@RequestBody Drone drone) {
        return droneService.createDrone(drone);
    }

    @GetMapping("/getBySerial")
    @ResponseBody
    public DroneDto getDroneBySerial(@RequestParam String serialNumber) {
        return droneService.getDroneBySerial(serialNumber);
    }

    @RequestMapping("/delete")
    public void deleteDroneBySerial(@RequestParam String serialNumber) {
        droneService.deleteDroneBySerial(serialNumber);
    }

    @PostMapping("/update")
    public DroneDto updateDrone(@RequestBody Drone drone) {
        return droneService.updateDrone(drone);
    }
}
