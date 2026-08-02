package com.gestion_de_note.gestion_de_note.cours.service;

import java.util.List;

import com.gestion_de_note.gestion_de_note.cours.Cours;
import com.gestion_de_note.gestion_de_note.cours.CoursRponsitory;
import com.gestion_de_note.gestion_de_note.cours.dto.CoursMapper;
import com.gestion_de_note.gestion_de_note.cours.dto.CoursRespounse;
import com.gestion_de_note.gestion_de_note.cours.dto.CoursRquestdto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CoursServiceImpl implements CoursService {


    @Autowired
    private  CoursRponsitory coursRepository;
    private  CoursMapper coursMapper;

    // 1. CREATE
    @Override
    public CoursRespounse creatCours(CoursRquestdto dto) {
        Cours cours = coursMapper.toEntity(dto);
        Cours saveCours = coursRepository.save(cours);
        return coursMapper.torRespounse(saveCours);
    }

    // 2. READ ALL
    @Override
    @Transactional(readOnly = true)
    public List<CoursRespounse> getAll() {
        return coursRepository.findAll()
                .stream()
                .map(coursMapper::torRespounse)
                .toList();
    }

    // 3. UPDATE (@MappingTarget Magic)
    @Override
    public CoursRespounse updateCours(Integer id_cours, CoursRquestdto dto) {
        // Step A: جيب الـ Entity من DB
        Cours existing = coursRepository.findById(id_cours)
                .orElseThrow(() -> new RuntimeException("Cours id not found: " + id_cours));

        // Step B: كب الداتا الجديدة د DTO فـ Entity القديمة
        coursMapper.toupdate(dto, existing);

        // Step C: حفظ فـ DB
        Cours saveCours = coursRepository.save(existing);

        // Step D: رجع Response DTO
        return coursMapper.torRespounse(saveCours);
    }

    // 4. DELETE
    @Override
    public void deltebyId(Integer id_cours) {
        if (!coursRepository.existsById(id_cours)) {
            throw new RuntimeException("Cours id not found: " + id_cours);
        }
        coursRepository.deleteById(id_cours);
    }
}