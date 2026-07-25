package com.gestion_de_note.gestion_de_note.inscrption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InscriRponsitory extends JpaRepository<Inscri, Integer> {

}