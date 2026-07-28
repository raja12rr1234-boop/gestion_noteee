package com.gestion_de_note.gestion_de_note.student.dto;

import java.time.LocalDate;

public class StudentResponseDto {

    private Integer idStudent;
    private String nom;
    private String prenom;
    private LocalDate dateLicence;
    private String email;
    private String numTelephone;

    // Constructors
    public StudentResponseDto() {
    }

    public StudentResponseDto(Integer idStudent, String nom, String prenom, LocalDate dateLicence, String email,
            String numTelephone) {
        this.idStudent = idStudent;
        this.nom = nom;
        this.prenom = prenom;
        this.dateLicence = dateLicence;
        this.email = email;
        this.numTelephone = numTelephone;
    }

    // Getters & Setters
    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

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

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }
}
