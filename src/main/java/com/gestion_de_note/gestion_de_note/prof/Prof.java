package com.gestion_de_note.gestion_de_note.prof;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prof")
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof")
    private Integer idprof;

    @Column(name = "nom")
    private String nom;

    @Column(name = "spcalite")
    private String specalite;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "mode_pass", nullable = false)
    private String password;

    public Prof() {
    }

    public Prof(Integer idprof, String nom, String specalite, String email, String password) {
        this.idprof = idprof;
        this.nom = nom;
        this.specalite = specalite;
        this.email = email;
        this.password = password;
    }

    public Integer getIdprof() {
        return idprof;
    }

    public void setIdprof(Integer idprof) {
        if (idprof != null) {
        this.idprof = idprof;
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

    public String getSpecalite() {
        return specalite;
    }

    public void setSpecalite(String specalite) {
        if (specalite != null) {
            this.specalite = specalite;
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
        if (password != null) {
            this.password = password;
        }
    }
}
