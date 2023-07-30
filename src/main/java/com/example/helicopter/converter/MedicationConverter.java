package com.example.helicopter.converter;

import com.example.helicopter.dto.MedicationDto;
import com.example.helicopter.entity.Medication;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MedicationConverter implements Converter<Medication, MedicationDto> {

    @Override
    public MedicationDto convert(Medication source) {
        return MedicationDto.builder()
                .name(source.getName())
                .weight(source.getWeight())
                .articul(source.getArticul())
                .pic(source.getPic())
                .build();
    }
}
