package com.example.demo.service;


import java.util.List;
import java.util.function.Consumer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.security.core.Authentication;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.dto.UserRegisterDTO;
import com.example.demo.model.entity.UserEntity;


public interface AppUserService
{
    UserEntity findById(@NotBlank final String id);


    UserEntity findByEmail(@NotBlank final String email);


    void persistUser(@NotNull final UserEntity user);


    void registerNewUser(@NotNull final UserRegisterDTO dto, @NotNull final Consumer<Authentication> authenticationConsumer);


    List<UserDTO> findAll();


    void delete(final String id);
}
