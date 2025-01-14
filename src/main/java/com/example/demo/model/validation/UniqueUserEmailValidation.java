package com.example.demo.model.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.example.demo.model.validation.validator.UniqueUserEmailValidator;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUserEmailValidator.class)
public @interface UniqueUserEmailValidation
{
    String message() default "Email already exists!";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
