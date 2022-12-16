//package com.example.MyApp.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.util.Calendar.FEBRUARY;
//import static java.util.Calendar.JUNE;
//
//@Configuration
//public class StudentConfig {
//
//  @Bean
//  CommandLineRunner commandLineRunner(StudentRepository repository) {
//    return args -> {
//      Student pavlin =
//          new Student("Pavlin Dimitrov", "pavlin@abv.bg", LocalDate.of(1989, FEBRUARY, 24).toString(),"Math");
//
//      Student martin =
//          new Student("Martin Dimitrov", "martin@abv.bg", LocalDate.of(1992, JUNE, 27).toString(), "Drama");
//
//      repository.saveAll(List.of(pavlin, martin));
//    };
//  }
//}
