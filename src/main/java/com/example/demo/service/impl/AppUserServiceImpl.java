package com.example.demo.service.impl;


import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.dto.UserRegisterDTO;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.mapping.PrincipalMapper;
import com.example.demo.model.mapping.UserMapper;
import com.example.demo.model.principal.ApplicationPrincipal;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AppUserService;
import com.example.demo.util.StringUtility;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService
{
    private final UserRepository userRepository;
    private final PrincipalMapper principalMapper;
    private final UserMapper userMapper;


    @Override
    public UserEntity findById(final String id)
    {
        return userRepository.findById(id).orElseThrow();
    }


    @Override
    public UserEntity findByEmail(@NotBlank final String email)
    {
        return userRepository.findByEmail(StringUtility.requireNotBlank(email))
                             .orElseThrow();
    }


    @Override
    public void persistUser(@NotNull final UserEntity user)
    {
        userRepository.saveAndFlush(Objects.requireNonNull(Objects.requireNonNull(user)));
    }


    @Override
    @Transactional
    public void registerNewUser(@NotNull final UserRegisterDTO dto, @NotNull final Consumer<Authentication> authenticationConsumer)
    {
        Objects.requireNonNull(dto);
        Objects.requireNonNull(authenticationConsumer);

        final ApplicationPrincipal principal = principalMapper.asPrincipal(userRepository.saveAndFlush(userMapper.toEntity(dto)));
        final Authentication authentication = new UsernamePasswordAuthenticationToken(principal,
                                                                                      principal.getPassword(),
                                                                                      principal.getAuthorities());
        authenticationConsumer.accept(authentication);
    }


    @Override
    @Transactional
    public List<UserDTO> findAll()
    {
        return List.copyOf(userRepository.findAll().stream().map(UserEntity::toDTO).toList());
    }


    @Override
    @Transactional
    public void delete(final String id)
    {
        userRepository.deleteById(id);
    }
}
