package com.example.demo.model.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.example.demo.model.validation.FieldsMatchValidation;


public class FieldsMatchValidator implements ConstraintValidator<FieldsMatchValidation, Object>
{
    private String first;
    private String second;
    private String message;


    @Override
    public void initialize(final FieldsMatchValidation constraintAnnotation)
    {
        first = constraintAnnotation.first();
        second = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context)
    {
        final BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        final Object firstValue = beanWrapper.getPropertyValue(first);
        final Object secondValue = beanWrapper.getPropertyValue(second);

        final boolean valid;

        if (firstValue == null)
        {
            valid = secondValue == null;
        }
        else
        {
            valid = firstValue.equals(secondValue);
        }

        if (!valid)
        {
            context.buildConstraintViolationWithTemplate(message)
                   .addPropertyNode(second)
                   .addConstraintViolation()
                   .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
