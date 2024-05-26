package com.example.demo.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import com.example.demo.model.enums.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "app_user_roles")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity extends BaseEntity
{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;


    @Override
    public Object toDTO()
    {
        throw new UnsupportedOperationException();
    }
}
