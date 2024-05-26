package com.example.demo.service;


import java.util.List;

import com.example.demo.model.dto.BrandDTO;
import com.example.demo.model.entity.BrandEntity;


public interface BrandService
{
    List<BrandEntity> getAllBrands();


    List<BrandDTO> getAllBrandsToDTO();
}
