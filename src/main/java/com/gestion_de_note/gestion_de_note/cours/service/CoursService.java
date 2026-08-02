package com.gestion_de_note.gestion_de_note.cours.service;

import java.util.List;

import com.gestion_de_note.gestion_de_note.cours.dto.CoursRespounse;
import com.gestion_de_note.gestion_de_note.cours.dto.CoursRquestdto;

public interface CoursService {

    CoursRespounse creatCours(CoursRquestdto dto);

    List<CoursRespounse> getAll();

    CoursRespounse updateCours(Integer id_cours, CoursRquestdto dto);

    List<CoursRespounse> gebyidList(Integer id_cours);

    void deltebyId(Integer id_cours);

}
