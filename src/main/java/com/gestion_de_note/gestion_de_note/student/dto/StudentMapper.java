package com.gestion_de_note.gestion_de_note.student.dto;

import org.mapstruct.Mapper;


import com.gestion_de_note.gestion_de_note.student.Student;

@Mapper(componentModel= "spring")
public interface StudentMapper {

    


StudentResponseDto tResponseDto(Student student);



}