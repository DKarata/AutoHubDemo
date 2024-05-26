package com.example.demo.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.BrandDTO;
import com.example.demo.model.entity.BrandEntity;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService
{
    private final BrandRepository brandRepository;


    @Override
    public List<BrandEntity> getAllBrands()
    {
        return brandRepository.findAll();
    }


    @Override
    @Transactional
    public List<BrandDTO> getAllBrandsToDTO()
    {
        return getAllBrands().stream().map(BrandEntity::toDTO).toList();
    }
}
