package com.gestion_de_note.gestion_de_note.cours.dto;


public record CoursRespounse(

        Integer id_cours,
        String nom_cours,

        Integer id_module,
        String nom_module,
        Integer note_module,

        Integer id_prof,
        String nom_prof,
        String specalite

) {
}