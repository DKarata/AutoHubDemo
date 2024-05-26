package com.example.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BrandService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController
{
    private final BrandService brandService;


    @GetMapping("/all")
    public String brands(Model model)
    {
        model.addAttribute("allBrands", brandService.getAllBrandsToDTO());
        return "brands";
    }
}
