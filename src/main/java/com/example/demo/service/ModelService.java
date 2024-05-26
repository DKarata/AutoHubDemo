package com.example.demo.service;


import jakarta.validation.constraints.NotBlank;

import com.example.demo.model.entity.ModelEntity;


public interface ModelService
{
    ModelEntity getByName(@NotBlank final String name);
}
