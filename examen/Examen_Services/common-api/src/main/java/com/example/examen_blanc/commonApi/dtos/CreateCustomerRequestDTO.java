package com.example.examen_blanc.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequestDTO {
    private String name;
    private String address;
    private String email;
    private String phone;
}
