package com.gestion_de_note.gestion_de_note.cours;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cours")
@CrossOrigin
public class CoursController {

    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping
    
    public List<Cours> getAllCours() {
        return coursService.getallCours();
    }

    @PostMapping
    public Cours Postparid(@RequestBody Cours cours) {
        return coursService.Postparid(cours);
    }

    @DeleteMapping("/{id_cours}")
    public void deletebyid(@PathVariable("id_cours") Integer id_cours) {
        coursService.deletebyid(id_cours);
    }

    @PutMapping("/{id_cours}")
    public Cours updateCoursparid(@PathVariable("id_cours") Integer id_cours, @RequestBody Cours cours) {
        return coursService.updateCoursparid(cours);
    }
}