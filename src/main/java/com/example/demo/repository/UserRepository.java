package com.example.demo.repository;


import java.util.Optional;

import jakarta.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>
{
    Optional<UserEntity> findByEmail(@NotBlank final String email);


    boolean existsByEmail(@NotBlank final String email);
}
