package com.example.demo.model.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.example.demo.model.validation.validator.FieldsMatchValidator;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatchValidation
{
    String first();


    String second();


    String message() default "Non-matching fields!";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
