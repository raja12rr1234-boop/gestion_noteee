package com.gestion_de_note.gestion_de_note.student.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDto {


       
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;
    
    private LocalDate dateLicence;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String password;

    private String numTelephone;

    // ✅ 1. Constructor خاوي ضروري لـ Spring Boot / Jackson
    public StudentRequestDto() {
    }

    // ✅ 2. Constructor بالبرامترات (تم تصحيح الاسم لـ StudentDto)
    public StudentRequestDto(String nom, String prenom, LocalDate dateLicence, String email, String password,
            String numTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateLicence = dateLicence;
        this.email = email;
        this.password = password;
        this.numTelephone = numTelephone;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateLicence() {
        return dateLicence;
    }

    public void setDateLicence(LocalDate dateLicence) {
        this.dateLicence = dateLicence;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }
}