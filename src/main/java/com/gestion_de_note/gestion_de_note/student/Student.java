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

    @Column(name = "proenom", length = 20)
    private String prenom;

    @Column(name = "date_licence")
    private LocalDate date_licence;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "num_telphone", length = 20)
    private String num_telphone;

    public Student() {
    }

    public Student(Integer idStudent, String nom, String prenom, LocalDate date_licence, String email, String password,
            String num_telphone) {
        this.idStudent = idStudent;
        this.nom = nom;
        this.prenom = prenom;
        this.date_licence = date_licence;
        this.email = email;
        this.password = password;
        this.num_telphone = num_telphone;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        if (idStudent != null || !"".equals(idStudent)) {
            this.idStudent = idStudent;
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom != null) {
            this.prenom = prenom;
        }
    }

    public LocalDate getDate_licence() {
        return date_licence;
    }

    public void setDate_licence(LocalDate date_licence) {
        if (date_licence != null) {
            this.date_licence = date_licence;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !"".equals(email)) {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !"".equals(password)) {
            this.password = password;
        }
    }

    public String getNum_telphone() {
        return num_telphone;
    }

    public void setNum_telphone(String num_telphone) {
        if (num_telphone != null && !"".equals(num_telphone)) {
            this.num_telphone = num_telphone;
        }
    }
    }
