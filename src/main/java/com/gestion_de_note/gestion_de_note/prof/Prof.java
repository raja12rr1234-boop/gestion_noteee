package com.gestion_de_note.gestion_de_note.prof;


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
@Table(name = "prof")
@NoArgsConstructor
@AllArgsConstructor
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof")
    private Integer idprof;

    @Column(name = "nom")
    private String nom;

    @Column(name = "spcalite")
    private String specalite;

    @Column(name = "email" ,unique= true , nullable= false)
    private String email;

    @Column(name = "mode_pass" , nullable= false)
    private String password;

}
