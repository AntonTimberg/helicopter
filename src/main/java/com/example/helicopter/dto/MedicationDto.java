package com.example.helicopter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MedicationDto {
    private String name;
    private Integer weight;
    private String articul;
    private String pic;
}
