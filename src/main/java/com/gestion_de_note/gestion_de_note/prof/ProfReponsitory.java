package com.gestion_de_note.gestion_de_note.prof;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfReponsitory extends JpaRepository<Prof, Integer> {


    Optional<Prof>findByEmail(String email);
}
