package com.example.helicopter.converter;

import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DroneConverter implements Converter<Drone, DroneDto> {
    @Override
    public DroneDto convert(Drone source) {
        return DroneDto.builder()
                .serialNumber(source.getSerialNumber())
                .batteryLevel(source.getBatteryLevel())
                .status(source.getStatus())
                .load(source.getLoad())
                .model(source.getModel())
                .build();
    }
}
