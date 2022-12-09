package com.example.MyApp.custom_validator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthLimitation, String> {

  @SneakyThrows
  @Override
  public boolean isValid(String dobField, ConstraintValidatorContext cvc) {
    ZoneId zone = ZoneId.systemDefault();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date dob = formatter.parse(dobField);
    LocalDate localDate = LocalDate.now();
    return dobField != null && dob.before(Date.from(localDate.atStartOfDay(zone).toInstant()));
  }
}