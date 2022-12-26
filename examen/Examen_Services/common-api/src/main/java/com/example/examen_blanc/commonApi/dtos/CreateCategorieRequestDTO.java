package com.example.examen_blanc.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategorieRequestDTO {
    private String name;
    private String desc;
}
