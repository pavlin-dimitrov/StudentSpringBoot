package com.example.MyApp.custom_validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface DateOfBirthLimitation {
  String message() default "Invalid DOB, enter earlier date!";
  Class<?> [] groups() default  {};
  Class<? extends Payload>[] payload() default {};
}
