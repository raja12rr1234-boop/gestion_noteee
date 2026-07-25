package com.gestion_de_note.gestion_de_note.student;

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
@RequestMapping("/api/v1/student")
@CrossOrigin
public class StudentController {

   private final StudenteService studenteService;

   public StudentController(StudenteService studenteService) {

      this.studenteService = studenteService;
   }

   @GetMapping

   public List<Student> getALLStudents() {

      return studenteService.getALLStudents();
   }

   @PostMapping

   public Student saveStudent(@RequestBody    Student student) {

      return studenteService.saveStudent(student);
   }

   @DeleteMapping("/{idStudent}")
   public void delteStudent(@PathVariable("idStudent")  Integer idStudent) {
       studenteService.deleteStudent(idStudent);
   }

   @PutMapping("/{idStudent}")

   public Student updateStudent(@PathVariable("idStudent") Integer idStudent ,@RequestBody Student student){
      

     return  studenteService.saveStudent(student);
   }
}
