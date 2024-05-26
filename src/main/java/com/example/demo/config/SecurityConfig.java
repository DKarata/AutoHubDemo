package com.example.demo.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import com.example.demo.model.mapping.PrincipalMapper;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.AppUserService;
import com.example.demo.service.impl.AppUserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception
    {
        return http.authorizeHttpRequests(authorize -> authorize.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                                                .permitAll()
                                                                .requestMatchers("/",
                                                                                 "/users/login",
                                                                                 "/users/register",
                                                                                 "/users/login-error")
                                                                .permitAll()
                                                                .anyRequest()
                                                                .authenticated())
                   .formLogin(login -> login.loginPage("/users/login")
                                            .failureForwardUrl("/users/login-error")
                                            .defaultSuccessUrl("/", true)
                                            .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                            .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY))
                   .logout(logout -> logout.logoutUrl("/users/logout")
                                           .logoutSuccessUrl("/")
                                           .invalidateHttpSession(true))
                   .build();
    }


    @Bean
    public UserDetailsService userDetailsService(final AppUserService appUserService,
                                                 final PrincipalMapper principalMapper,
                                                 final UserRoleRepository userRoleRepository)
    {
        //        final UserRoleEntity adminRole = userRoleRepository.saveAndFlush(UserRoleEntity.builder().role(UserRoleEnum.ADMIN).build());
        //        userRoleRepository.saveAndFlush(UserRoleEntity.builder().role(UserRoleEnum.MODERATOR).build());
        //        userRoleRepository.saveAndFlush(UserRoleEntity.builder().role(UserRoleEnum.USER).build());
        //        final UserEntity admin = UserEntity.builder()
        //                                           .email("admin@admin.com")
        //                                           .active(true)
        //                                           .firstName("Admin")
        //                                           .lastName("Adminov")
        //                                           .password(passwordEncoder().encode("admin"))
        //                                           .roles(List.of(adminRole))
        //                                           .build();
        //        appUserService.persistUser(admin);

        // you can create default user here or via data.sql

        return new AppUserDetailsServiceImpl(appUserService, principalMapper);
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityContextRepository securityContextRepository()
    {
        return new DelegatingSecurityContextRepository(
                        new RequestAttributeSecurityContextRepository(),
                        new HttpSessionSecurityContextRepository()
        );
    }
}
