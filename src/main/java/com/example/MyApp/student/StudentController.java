package com.example.MyApp.student;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
// @RequestMapping("/api")
public class StudentController {

  @Autowired private final StudentService studentService;

  //    @GetMapping("/all")
  //    public List<Student> getStudents() {
  //        return studentService.getStudents();
  //    }

  @GetMapping("/students")
  public String viewHomePage(Model model) {
    List<Student> students = studentService.getStudents();
    model.addAttribute("students", students);
    return "students";
  }

  // TODO ALTERNATIVE WAY using ResponseEntity generic class...
  //    @GetMapping("/allStudents")
  //    public ResponseEntity<List<Student>> getAllStudents(){
  //        List<Student> students = studentService.getStudents();
  //        return new ResponseEntity<>(students, HttpStatus.OK);
  //    }

  @GetMapping("/addnew")
  public String addNewStudent(Model model) {
    model.addAttribute("student", new Student());
    return "newstudent";
  }

  @PostMapping("/save")
  public String saveStudent(@Valid Student student, BindingResult result,Model model) {
    boolean thereIsError = result.hasErrors();
    if (thereIsError){
      return "newstudent";
    } else {
      model.addAttribute("student", student);
      studentService.addNewStudent(student);
      return "redirect:/students";
    }
  }

  @GetMapping("/edit/{id}")
  public String editStudentForm(@PathVariable Long id, Model model) {
    model.addAttribute("student", studentService.getStudentById(id));
    return "update";
  }

  @PostMapping("/updateStudent/{id}")
  public String updateStudent(
      @PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

    // get student from database by id
    Optional<Student> existingStudent = studentService.getStudentById(id);
    String name = student.getName();
    String email = student.getEmail();

    // save updated student object
    studentService.updateStudent(existingStudent, name, email);
    return "redirect:/students";
  }

  @GetMapping("/deleteStudent/{id}")
  public String deleteThroughId(@PathVariable(value = "id") long id) {
    studentService.deleteStudent(id);
    return "redirect:/";
  }

  @GetMapping(path = "{name}")
  public List<Student> findByName(@PathVariable("name") String name) {
    return studentService.findStudentByName(name);
  }
}
