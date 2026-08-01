package com.gestion_de_note.gestion_de_note.prof.dto;

import org.mapstruct.Mapper;

import com.gestion_de_note.gestion_de_note.prof.Prof;

import jakarta.persistence.Entity;

@Mapper(componentModel = "spring")
public interface ProfMapper {

  Profresponsedto toProfresponsedto(Prof prof);

  Prof toEntity(Profrequestdto dto);
}