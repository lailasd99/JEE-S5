package com.example.examen_blanc.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderLigneRequestDTO {
    private int quantity;
    private double price;
    private double remise;
}
