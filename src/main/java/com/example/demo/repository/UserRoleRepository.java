package com.example.demo.repository;


import java.util.Optional;

import jakarta.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.UserRoleEntity;
import com.example.demo.model.enums.UserRoleEnum;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String>
{
    Optional<UserRoleEntity> findByRole(@NotNull final UserRoleEnum role);
}
