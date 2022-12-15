package com.example.MyApp.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

  @Autowired private final StudentRepository studentRepository;

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
    if (studentByEmail.isPresent()) {
      throw new IllegalStateException("Email is taken! Use another e-mail address!");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean studentExists = studentRepository.existsById(studentId);
    if (!studentExists) {
      throw new IllegalStateException("Student with ID: " + studentId + " does not exists!");
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudent(Student studentId, String name, String email) {
    Student student =
        studentRepository
            .findById(studentId.getId())
            .orElseThrow(
                () ->
                    new IllegalStateException(
                        "Student with ID: " + studentId + " does not exists"));

    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }

    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
      student.setEmail(email);
    }
    studentRepository.save(student);
  }

  public Optional<Student> getStudentById(Long id) {
    return studentRepository.findById(id);
  }

  public List<Student> findStudentByName(String name) {
    return studentRepository.findByNameContainsIgnoreCase(name);
  }
}
