package com.example.demo.model.mapping;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;

import org.mapstruct.MapperConfig;
import org.mapstruct.Named;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.UserRegisterDTO;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.entity.UserRoleEntity;
import com.example.demo.model.enums.UserRoleEnum;
import com.example.demo.repository.UserRoleRepository;

import lombok.RequiredArgsConstructor;


@Component
@MapperConfig
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class MapperUtil
{
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;


    @Named("encodePassword")
    public String encodePassword(String password)
    {
        return passwordEncoder.encode(password);
    }


    @Named("defaultRole")
    public List<UserRoleEntity> defaultRole(@NotNull final UserRegisterDTO dto)
    {
        ArrayList<UserRoleEntity> role = new ArrayList<>();
        userRoleRepository.findByRole(UserRoleEnum.USER).ifPresent(role::add);
        return role;
    }


    @Named("fullName")
    public String fullName(@NotNull final UserEntity user)
    {
        Objects.requireNonNull(user);
        return user.getFirstName() + " " + user.getLastName();
    }


    @Named("grantedAuthority")
    public List<SimpleGrantedAuthority> grantedAuthority(@NotNull final List<UserRoleEntity> roles)
    {
        return Objects.requireNonNull(roles).stream()
                      .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                      .toList();
    }
}
