package com.gestion_de_note.gestion_de_note.cours;

import com.gestion_de_note.gestion_de_note.prof.Prof;
import com.gestion_de_note.gestion_de_note.module.Module;
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
@Table(name = "cours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cours")
    private Integer id_cours;

    @Column(name = "nom_cours")
    private String nom_cours;

    @ManyToOne
    @JoinColumn(name = "id_module")

    private Module module;

    @ManyToOne
    @JoinColumn(name = "id_prof")
    private Prof prof;

}
