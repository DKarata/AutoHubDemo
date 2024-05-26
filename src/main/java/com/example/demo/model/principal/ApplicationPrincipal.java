package com.example.demo.model.principal;


import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.util.StringUtility;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApplicationPrincipal extends User
{
    private String id;
    private String fullName;


    public ApplicationPrincipal(final String username,
                                final String password,
                                final Collection<? extends GrantedAuthority> authorities)
    {
        super(StringUtility.requireNotBlank(username), StringUtility.requireNotBlank(password), Objects.requireNonNull(authorities));
    }
}
