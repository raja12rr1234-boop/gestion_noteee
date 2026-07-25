package com.gestion_de_note.gestion_de_note.prof;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProfSrvice {

    private final ProfReponsitory profReponsitory;

    public ProfSrvice(ProfReponsitory profReponsitory) {

        this.profReponsitory = profReponsitory;
    }

    public List<Prof> getallPofs() {

        return profReponsitory.findAll();
    }

    public Prof Postparid(Prof prof) {

        return profReponsitory.save(prof);
    }

    public Prof updateprofparid(Prof upadateProf) {

        return profReponsitory.save(upadateProf);
    }

    public void deletebyid(Integer idprof) {

        profReponsitory.deleteById(idprof);
    }
}
