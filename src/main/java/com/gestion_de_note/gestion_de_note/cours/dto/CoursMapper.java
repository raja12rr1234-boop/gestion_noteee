package com.gestion_de_note.gestion_de_note.cours.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.gestion_de_note.gestion_de_note.cours.Cours;

@Mapper(componentModel = "spring")
public interface CoursMapper {
    // 1️⃣ تحويل الـ Entity (Cours) ──► لـ Response DTO (باش ترجع الداتا للـ
    // Front-end)

    CoursRespounse torRespounse(Cours cours);

    Cours toEntity(CoursRquestdto dto);
    void updateCoursFromDto(CoursRquestdto dto, @MappingTarget Cours entity);
}
