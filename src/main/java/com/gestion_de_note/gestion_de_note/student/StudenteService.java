package com.gestion_de_note.gestion_de_note.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudenteService {

    private final StudentRepository studentRepository;

    public StudenteService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getALLStudents() {

        return studentRepository.findAll();

    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // 4. مسح طالب بـ ID (Delete)
    // 4. مسح طالب بـ ID (Delete)
    public void deleteStudent( Integer idStudent) {

        studentRepository.deleteById(idStudent);

    }

   // 5. Update ساهل ومباشر 100%
    public Student updateStudent(Student updatedStudent) {
        // save() فـ Spring Data JPA كتدير UPDATE أوتوماتيكياً إلا كان الـ Object فيه ID كاين فـ الداتابيس
        return studentRepository.save(updatedStudent);
    }

}
