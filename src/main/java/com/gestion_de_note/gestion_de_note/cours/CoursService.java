package com.gestion_de_note.gestion_de_note.cours;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CoursService {

    private final CoursRponsitory coursRponsitory;

    public CoursService(CoursRponsitory coursRponsitory) {

        this.coursRponsitory = coursRponsitory;
    }

    public List<Cours> getallCours() {

        return coursRponsitory.findAll();
    }

    public Cours Postparid(Cours cours) {

        return coursRponsitory.save(cours);
    }

    public Cours updateCoursparid(Cours upadateCours) {

        return coursRponsitory.save(upadateCours);
    }

    public void deletebyid(Integer id_cours) {

        coursRponsitory.deleteById(id_cours);
    }
}
