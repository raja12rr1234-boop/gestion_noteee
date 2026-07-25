package com.gestion_de_note.gestion_de_note.inscrption;

import com.gestion_de_note.gestion_de_note.cours.Cours;
import com.gestion_de_note.gestion_de_note.student.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "inscrption")
@AllArgsConstructor
@NoArgsConstructor
public class Inscri {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscrption")

    private Integer id_inscrption;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "id_cours")

    private Cours cours;

}
