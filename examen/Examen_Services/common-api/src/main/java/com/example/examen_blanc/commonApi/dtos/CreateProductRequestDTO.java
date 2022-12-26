package com.example.examen_blanc.commonApi.dtos;

import com.example.examen_blanc.commonApi.enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDTO {
    private String name;
    private double price;
    private int stock;
    private Etat state;
}
