package com.gestion_de_note.gestion_de_note.student;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;
    @Column(name = "nom")
    private String nom;
    @Column(name = "proenom", length = 20)
    private String prenom;

    @Column(name = "date_licence", length = 30)
    private LocalDate date_licence;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = true)

    private String password;
    @Column(name = "num_telphone", length = 20)
    private String num_telphone;

}
