package com.example.examen_blanc.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProprietaireRequestDTO {
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;
}
