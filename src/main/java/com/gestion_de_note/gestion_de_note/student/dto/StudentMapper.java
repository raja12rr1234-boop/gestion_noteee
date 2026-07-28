package com.gestion_de_note.gestion_de_note.student.dto;

import com.gestion_de_note.gestion_de_note.student.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Student student = new Student();
        student.setNom(dto.getNom());
        student.setPrenom(dto.getPrenom());
        student.setDateLicence(dto.getDateLicence());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());
        student.setNumTelephone(dto.getNumTelephone());

        return student;
    }

    public StudentResponseDto toResponseDto(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponseDto dto = new StudentResponseDto();
        
        // ⚠️ إلا كانت الـ ID فـ Entity اسمها id بدلها لـ student.getId()
        dto.setId(student.getId()); 
        dto.setNom(student.getNom());
        dto.setPrenom(student.getPrenom());
        dto.setDateLicence(student.getDateLicence());
        dto.setEmail(student.getEmail());
        dto.setNumTelephone(student.getNumTelephone());

        return dto;
    }
}