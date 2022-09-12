package com.example.MyApp.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@AllArgsConstructor
//@RequestMapping("/api")
public class StudentController {

    @Autowired
    private final StudentService studentService;

//    @GetMapping("/all")
//    public List<Student> getStudents() {
//        return studentService.getStudents();
//    }

    @GetMapping("/students")
    public String viewHomePage(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    //TODO ALTERNATIVE WAY using ResponseEntity generic class...
//    @GetMapping("/allStudents")
//    public ResponseEntity<List<Student>> getAllStudents(){
//        List<Student> students = studentService.getStudents();
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }

    @GetMapping("/addnew")
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "newstudent";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students";
    }

//    @PostMapping("/newStudent")
//    public void registerNewStudent(@RequestBody Student student) {
//        studentService.addNewStudent(student);
//    }

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

    @GetMapping(path = "{name}")
    public List<Student> findByName(@PathVariable("name") String name) {
        return studentService.findStudentByName(name);
    }
}
