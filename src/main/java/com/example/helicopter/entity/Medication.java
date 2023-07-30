package com.example.helicopter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication")
@Data
@Builder
public class Medication {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer weight;
    private String articul;
    private String pic;
}
