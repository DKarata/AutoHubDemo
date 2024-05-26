package com.example.demo.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.model.validation.FieldsMatchValidation;
import com.example.demo.model.validation.UniqueUserEmailValidation;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@FieldsMatchValidation(
                first = "password",
                second = "confirmPassword",
                message = "паролата и паролата за потвърждение трябва да са еднакви!"
)
public class UserRegisterDTO
{
    @NotBlank(message = "Моля въведете първо име.")
    @Size(min = 2, max = 20, message = "Първото име трябва да е от 2 до 20 символа.")
    private String firstName;

    @NotBlank(message = "Моля въведете фамилия.")
    @Size(min = 2, max = 20, message = "Фамилията трябва да е от 2 до 20 символа.")
    private String lastName;

    @NotBlank(message = "Моля въведете имейл.")
    @Email(message = "Имейлът трябва да бъде валиден.")
    @UniqueUserEmailValidation
    private String email;

    @NotBlank(message = "Моля въведете парола.")
    @Size(min = 5, message = "Паролата трябва да бъде поне 5 символа.")
    private String password;

    @NotBlank(message = "Моля въведете парола за потвърждение.")
    private String confirmPassword;


    @Override
    public String toString()
    {
        return "UserRegisterDTO{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
               ", confirmPassword='" + (confirmPassword != null ? "[PROVIDED]" : null) + '\'' +
               '}';
    }
}
