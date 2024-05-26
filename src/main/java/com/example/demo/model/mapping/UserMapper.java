package com.example.demo.model.mapping;


import jakarta.validation.constraints.NotNull;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.model.dto.UserRegisterDTO;
import com.example.demo.model.entity.UserEntity;


@Mapper(componentModel = "spring", uses = {MapperUtil.class})
public interface UserMapper
{
    @Mapping(target = "imageUrl", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "password", source = "userRegisterDTO.password", qualifiedByName = "encodePassword")
    @Mapping(target = "roles", source = "userRegisterDTO", qualifiedByName = "defaultRole")
    UserEntity toEntity(@NotNull final UserRegisterDTO userRegisterDTO);
}
