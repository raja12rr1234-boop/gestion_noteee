package com.gestion_de_note.gestion_de_note.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    
 
@Repository
    public interface StudentRepository extends JpaRepository <Student , Integer> {
    
         Optional<Student> findByemail( String email);
    }

