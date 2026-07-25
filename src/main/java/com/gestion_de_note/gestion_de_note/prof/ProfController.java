package com.gestion_de_note.gestion_de_note.prof;

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
@RequestMapping("api/v1/prof")
@CrossOrigin
public class ProfController {

    private final ProfSrvice profSrvice;

    public ProfController(ProfSrvice profSrvice) {

        this.profSrvice = profSrvice;
    }

    @GetMapping

    public List<Prof> getAllProfs() {
        return profSrvice.getallPofs();
    }

    @PostMapping

    public Prof postparid(@RequestBody Prof prof) {

        return profSrvice.Postparid(prof);
    }

    @PutMapping("{idprof}")

    public Prof updateprofparid(@PathVariable("idprof") Integer idprof, @RequestBody Prof prof) {

        return profSrvice.Postparid(prof);
    }

    @DeleteMapping("{idprof}")

    public void deltebyid(@PathVariable("idprof") Integer idprof) {
        profSrvice.deletebyid(idprof);
    }
}
