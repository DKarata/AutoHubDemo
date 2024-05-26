package com.example.demo.web;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.principal.ApplicationPrincipal;
import com.example.demo.service.AppUserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminController
{
    private final AppUserService appUserService;


    @GetMapping("/user-management")
    public ModelAndView userManagement()
    {
        final List<UserDTO> allUsers = appUserService.findAll();

        return new ModelAndView("admin").addObject("allUsers", allUsers);
    }


    @PostMapping("/user-management/{id}")
    public ModelAndView userManagement(@PathVariable final String id,
                                       @AuthenticationPrincipal final ApplicationPrincipal principal)
    {
        if (!principal.getId().equals(id))
        {
            appUserService.delete(id);
        }
        return new ModelAndView("redirect:/admin/user-management");
    }
}
