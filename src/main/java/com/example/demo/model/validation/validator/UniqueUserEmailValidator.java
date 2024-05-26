package com.example.demo.model.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.example.demo.model.validation.UniqueUserEmailValidation;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.StringUtility;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmailValidation, String>
{
    private final UserRepository userRepository;


    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context)
    {
        return !userRepository.existsByEmail(StringUtility.requireNotBlank(value));
    }
}
