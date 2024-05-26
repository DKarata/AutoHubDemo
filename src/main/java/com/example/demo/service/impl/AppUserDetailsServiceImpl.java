package com.example.demo.service.impl;


import jakarta.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.mapping.PrincipalMapper;
import com.example.demo.service.AppUserService;
import com.example.demo.util.StringUtility;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AppUserDetailsServiceImpl implements UserDetailsService
{
    private final AppUserService appUserService;
    private final PrincipalMapper principalMapper;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(@NotNull final String email) throws UsernameNotFoundException
    {
        return principalMapper.asPrincipal(appUserService.findByEmail(StringUtility.requireNotBlank(email)));
    }
}
