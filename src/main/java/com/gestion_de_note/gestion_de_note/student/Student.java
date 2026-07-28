package com.gestion_de_note.gestion_de_note.student;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom", length = 20) // 👈 صلّحنا proenom
    private String prenom;

    @Column(name = "date_licence")
    private LocalDate dateLicence; // 👈 ردينها camelCase

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "num_telephone", length = 20) // 👈 صلّحنا num_telephone
    private String numTelephone;

    // Default Constructor
    public Student() {
    }

    // All-args Constructor
    public Student(Integer idStudent, String nom, String prenom, LocalDate dateLicence, String email, String password,
            String numTelephone) {
        this.idStudent = idStudent;
        this.nom = nom;
        this.prenom = prenom;
        this.dateLicence = dateLicence;
        this.email = email;
        this.password = password;
        this.numTelephone = numTelephone;
    }

    // Getters & Setters نقاب بلا معيقات
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