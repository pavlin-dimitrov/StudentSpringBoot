package com.example.MyApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findStudentByEmail(String email);

  List<Student> findByNameContainsIgnoreCase(String name);

  @Query("select s from Student s where s.id = ?1")
  Optional<Student> findById(Student student);

  //    Optional<Student> getStudentById(Long id);

}
