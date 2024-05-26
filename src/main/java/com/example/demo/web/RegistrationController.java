package com.example.demo.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.dto.UserRegisterDTO;
import com.example.demo.service.AppUserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class RegistrationController
{
    private final AppUserService appUserService;
    private final SecurityContextRepository securityContextRepository;


    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel()
    {
        return new UserRegisterDTO();
    }


    @GetMapping("/register")
    public String register()
    {
        return "auth-register";
    }


    @PostMapping("/register")
    public String register(@Valid @NotNull final UserRegisterDTO userRegisterDTO,
                           final BindingResult bindingResult,
                           final RedirectAttributes redirectAttributes,
                           final HttpServletRequest request,
                           final HttpServletResponse response)
    {
        if (bindingResult.hasErrors())
        {
            redirectAttributes.addFlashAttribute("userModel", userRegisterDTO)
                              .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        appUserService.registerNewUser(userRegisterDTO, a ->
        {
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(a);
            SecurityContextHolder.setContext(context);
            securityContextRepository.saveContext(context, request, response);
        });
        return "redirect:/";
    }
}
