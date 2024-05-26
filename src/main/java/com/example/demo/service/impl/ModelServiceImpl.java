package com.example.demo.service.impl;


import org.springframework.stereotype.Service;

import com.example.demo.model.entity.ModelEntity;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.ModelService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService
{
    private final ModelRepository modelRepository;


    @Override
    public ModelEntity getByName(final String name)
    {
        return modelRepository.findByModelName(name).orElseThrow();
    }
}
