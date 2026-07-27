package com.gestion_de_note.gestion_de_note.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService; // 1. زدنا ה-Import د Interface

import com.gestion_de_note.gestion_de_note.prof.Prof;
import com.gestion_de_note.gestion_de_note.prof.ProfReponsitory;
import com.gestion_de_note.gestion_de_note.student.Student;
import com.gestion_de_note.gestion_de_note.student.StudentRepository;

import io.jsonwebtoken.security.Password;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private ProfReponsitory profReponsitory;

    @Autowired
    private StudentRepository studentRepository;
    /*
     * la methode pour 1 option
     * 
     * @Override
     * public UserDetails loadUserByUsername(String email) throws
     * UsernameNotFoundException {
     * 
     * Prof prof = profReponsitory.findByEmail(email)
     * .orElseThrow(() -> new
     * UsernameNotFoundException("User not found with email: " + email));
     * 
     * return User.builder()
     * .username(prof.getEmail())
     * .password(prof.getPassword())
     * .roles("PROF")
     * .build();
     * }
     */

    /// la methode 2 pour 2 options de secrytes est changerr les mode pase pour
    /// customUserdetail (Bcrypt);

    @Override

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Prof> profOpt = profReponsitory.findByEmail(email);
        if (profOpt.isPresent()) {

            Prof prof = profOpt.get();
            return User.builder()
                    .username(prof.getEmail())
                    .password(prof.getPassword())
                    .roles("PROF")
                    .build();
        }

        Optional<Student> stuOptional = studentRepository.findByemail(email);

         if(stuOptional.isPresent()){

            Student student = stuOptional.get();

            return  User.builder()
               .username(student.getEmail())
               .password(student.getPassword())
               .roles("STUDENT")
               .build();
         }

          throw new UsernameNotFoundException(" user is not found :"+ email);
    }

}