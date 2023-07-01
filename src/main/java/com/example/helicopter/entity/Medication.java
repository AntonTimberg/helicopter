package com.example.helicopter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Medication {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer weight;
    private String articul;
    private String pic;
}
