package com.gestion_de_note.gestion_de_note.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRponsitory extends JpaRepository<Module, Integer> {

}