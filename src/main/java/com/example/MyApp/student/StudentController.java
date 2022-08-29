package com.example.MyApp.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //TODO ALTERNATIVE WAY using ResponseEntity generic class...
//    @GetMapping("/allStudents")
//    public ResponseEntity<List<Student>> getAllStudents(){
//        List<Student> students = studentService.getStudents();
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }

    @PostMapping("/newStudent")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);

    }
}