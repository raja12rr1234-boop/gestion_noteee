package com.gestion_de_note.gestion_de_note.module;

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
@Data
@Table(name = "module")
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_module")
    private Integer id_module;

    @Column(name = "nom_module")

    private String nom_module;

    @Column(name = "note_module")
    private Integer note_module;

}
