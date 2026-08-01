package com.gestion_de_note.gestion_de_note.cours.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gestion_de_note.gestion_de_note.cours.Cours;

@Mapper(componentModel = "spring")
public interface CoursMapper {
    // 1️⃣ تحويل الـ Entity (Cours) ──► لـ Response DTO (باش ترجع الداتا للـ
    // Front-end)
    @Mapping(source = "module.id_module", target = "id_module")
    @Mapping(source = "module.nom_module", target = "nom_module")
    @Mapping(source = "module.note_module", target = "note_module")
    @Mapping(source = "prof.id_prof", target = "id_prof")
    @Mapping(source = "prof.nom", target = "nom")
    @Mapping(source = "prof.specalite", target = "specalite")
  
     CoursRespounse torRespounse( Cours cours);

    // 2️⃣ تحويل الـ Request DTO ──► لـ Entity (باش تسوفغاردي كورس جديد فـ DB)
    @Mapping(target = "id_cours", ignore = true) // حيت الـ ID كيتجنرا أوتوماتيك فـ الداتابيز
    @Mapping(target = "module", ignore = true) // غانلصقو الـ Module بيدك فـ Service بـ findById(dto.getId_module())
    @Mapping(target = "prof", ignore = true) // غانلصقو الـ Prof بيدك فـ Service بـ findById(dto.getId_prof())
    Cours toEntity(CoursRquestdto dto);
}
