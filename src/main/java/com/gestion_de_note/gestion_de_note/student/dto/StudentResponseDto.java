package com.gestion_de_note.gestion_de_note.student.dto;

import java.time.LocalDate;

public record StudentResponseDto(
                Integer idStudent,
                String nom,
                String prenom,
                LocalDate dateLicence,
                String email,
                String numTelephone

) {
}