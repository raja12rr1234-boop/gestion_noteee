package com.gestion_de_note.gestion_de_note.cours.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursRquestdto {

    @NotBlank(message = " nom de cours est obligatoire")
    private String nom_cours;

    @NotNull(message = " nom de module est obligatoire")
    private Long id_module;
    @NotNull(message = "nom de prof est obligatoire")

    private Long id_prof;
}

/*
    public CoursRquestdto(){

    }
    public CoursRquestdto(String nom_cours, Long id_module, Long id_prof) {

        this.nom_cours = nom_cours;
        this.id_module = id_module;
        this.id_prof = id_prof;

    }

    public String getNom_cours() {
        return nom_cours;
    }

    public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }

    public Long getId_module() {

        return id_module;
    }

    public void setId_module(Long id_module) {
        this.id_module = id_module;

    }

    public Long getId_prof() {
        return id_prof;
    }

    public void setId_prof(Long id_prof) {

        this.id_prof = id_prof;
    }
}
 */