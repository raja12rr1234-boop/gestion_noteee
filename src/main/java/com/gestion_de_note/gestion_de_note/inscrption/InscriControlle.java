package com.gestion_de_note.gestion_de_note.inscrption;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriControlle {

    private final InscriService inscriService;

    public InscriControlle(InscriService inscriService) {
        this.inscriService = inscriService;
    }

    // 1. GET ALL
    @GetMapping
    public List<Inscri> getAllInscriptions() {
        return inscriService.getAllInscriptions();
    }

    // 2. CREATE
    @PostMapping
    public Inscri createInscription(@RequestBody Inscri inscription) {
        return inscriService.createInscription(inscription);
    }

    // 3. DELETE (3adiyya w bsiṭa)
    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable("id") Integer id_inscrption) {
        inscriService.deleteInscription(id_inscrption);
    }
}