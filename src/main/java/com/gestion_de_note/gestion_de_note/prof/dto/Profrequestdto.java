package com.gestion_de_note.gestion_de_note.prof.dto;

import jakarta.validation.constraints.NotBlank;

public class Profrequestdto {

    @NotBlank(message = "le name est obligatoire")
    private String nom;

    @NotBlank(message = " le specailite est oubligataoire")

    private String specalite;

    @NotBlank(message = "le email est pobligatiore pour login de compet")

    private String email;

    @NotBlank(message = "le modepassse est obleigatore pour login de mon compet")

    private String password;

    public Profrequestdto(String nom, String specalite, String email, String password) {

        this.nom = nom;
        this.specalite = specalite;
        this.email = email;
        this.password = password;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpcalite() {
        return specalite;
    }

    public void setSpecalite(String specalite) {
        this.specalite = specalite;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pssword) {

        this.password = password;
    }
}
