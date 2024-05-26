package com.example.demo.model.dto;


import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BrandDTO
{
    private String name;
    private List<ModelDTO> models;
}
