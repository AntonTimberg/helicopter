package com.example.helicopter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class DroneDto {
    private String serialNumber;
    private String model;
    private Integer load;
    private Integer batteryLevel;
    private String status;
}
