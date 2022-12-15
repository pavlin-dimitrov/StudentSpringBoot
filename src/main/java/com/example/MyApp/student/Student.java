package com.example.MyApp.student;

import com.example.MyApp.audit.Auditable;
import com.example.MyApp.custom_validator.DateOfBirthLimitation;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student extends Auditable<String> implements Serializable {
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;
  @NotNull (message = "must be NOT empty!")
  @NotBlank (message = "must be NOT empty!")
  private String name;

  @Email
  private String email;

  @DateOfBirthLimitation
  private String dob;

  @Transient private Integer age;
  
  private String exam;

  public Student(String name, String email, String dob, String exam) {
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.exam = exam;
  }

    public Integer getAge() {
      return Period.between(LocalDate.parse(this.dob), LocalDate.now()).getYears();
    }
}
