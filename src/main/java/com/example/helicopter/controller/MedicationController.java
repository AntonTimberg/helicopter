package com.example.helicopter.controller;

import com.example.helicopter.dto.MedicationDto;
import com.example.helicopter.entity.Medication;
import com.example.helicopter.service.MedicationService;
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
@RequestMapping("/medication")
public class MedicationController {
    private final MedicationService medicationService;

    @RequestMapping("create")
    public MedicationDto createMedication(@RequestBody Medication medication) {
        return medicationService.createMedication(medication);
    }

    @RequestMapping("/getAll")
    public List<MedicationDto> getAll() {
        return medicationService.getAll();
    }

    @GetMapping("/getByArticul")
    @ResponseBody
    public MedicationDto getMedicationByArticul(@RequestParam String articul) {
        return medicationService.getMedicationByArtucul(articul);
    }

    @RequestMapping("/delete")
    public void deleteMedicationByArticul(@RequestParam String articul) {
        medicationService.deleteMedicationByArticul(articul);
    }

    @PostMapping("/update")
    public MedicationDto updateMedication(@RequestBody Medication medication) {
        return medicationService.updateMedication(medication);
    }
}
