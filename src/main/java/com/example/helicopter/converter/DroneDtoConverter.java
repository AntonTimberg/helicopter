package com.example.helicopter.converter;

import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DroneDtoConverter implements Converter<DroneDto, Drone> {
    @Override
    public Drone convert(DroneDto source) {
        return Drone.builder()
                .serialNumber(source.getSerialNumber())
                .batteryLevel(source.getBatteryLevel())
                .status(source.getStatus())
                .load(source.getLoad())
                .model(source.getModel())
                .build();
    }
}
