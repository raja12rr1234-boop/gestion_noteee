package com.gestion_de_note.gestion_de_note.cours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_de_note.gestion_de_note.cours.dto.CoursRespounse;
import com.gestion_de_note.gestion_de_note.cours.dto.CoursRquestdto;
import com.gestion_de_note.gestion_de_note.cours.service.CoursService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cours")
@CrossOrigin(origins = "*")
public class CoursController {

    @Autowired
    private CoursService coursService;

    // 1. Get All Cours
    // URL: GET http://localhost:8080/api/v1/cours
    @GetMapping
    public ResponseEntity<List<CoursRespounse>> getAll() {
        List<CoursRespounse> list = coursService.getAll();
        return ResponseEntity.ok(list); // Returns 200 OK with list JSON
    }

    // 2. Get Cours By ID
    // URL: GET http://localhost:8080/api/v1/cours/1
    @GetMapping("/{id}")
    public ResponseEntity<List<CoursRespounse>> getById(@PathVariable("id") Integer id_cours) {
        List<CoursRespounse> coursList = coursService.gebyidList(id_cours);
        return ResponseEntity.ok(coursList);
    }

    // 3. Create Cours
    // URL: POST http://localhost:8080/api/v1/cours
    @PostMapping
    public ResponseEntity<CoursRespounse> createCours(@Valid @RequestBody CoursRquestdto dto) {
        CoursRespounse createdCours = coursService.creatCours(dto);
        return new ResponseEntity<>(createdCours, HttpStatus.CREATED); // Returns 201 Created
    }

    // 4. Update Cours
    // URL: PUT http://localhost:8080/api/v1/cours/1
    @PutMapping("/{id}")
    public ResponseEntity<CoursRespounse> updateCours(
            @PathVariable("id") Integer id_cours,
            @Valid @RequestBody CoursRquestdto dto) {
            
        CoursRespounse updatedCours = coursService.updateCours(id_cours, dto);
        return ResponseEntity.ok(updatedCours);
    }

    // 5. Delete Cours
    // URL: DELETE http://localhost:8080/api/v1/cours/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id_cours) {
        coursService.deltebyId(id_cours);
        return ResponseEntity.noContent().build(); // Returns 204 No Content
    }
}