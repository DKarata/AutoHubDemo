package com.example.demo.model.mapping;


import jakarta.validation.constraints.NotNull;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.principal.ApplicationPrincipal;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {MapperUtil.class})
public interface PrincipalMapper
{
    @Mapping(target = "username", source = "email")
    @Mapping(target = "fullName", source = "user", qualifiedByName = "fullName")
    @Mapping(target = "authorities", source = "roles", qualifiedByName = "grantedAuthority")
    ApplicationPrincipal asPrincipal(@NotNull final UserEntity user);
}
