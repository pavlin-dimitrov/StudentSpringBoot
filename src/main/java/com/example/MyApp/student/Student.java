package com.example.MyApp.student;

import com.example.MyApp.custom_validator.DateOfBirthLimitation;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;
  @NotNull
  private String name;

  private String email;

  @DateOfBirthLimitation()
  private String dob;

  @Transient private Integer age;

  public Student(String name, String email, String dob) {
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  //  public Integer getAge() {
  //    return Period.between(this.dob, LocalDate.now()).getYears();
  //  }
}
