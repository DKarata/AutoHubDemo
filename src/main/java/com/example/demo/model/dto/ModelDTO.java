package com.example.demo.model.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.example.demo.model.enums.CategoryEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ModelDTO
{
    @NotBlank(message = "Името на модела на може да бъде нула или празно!")
    private String name;

    @NotNull(message = "Категорията на модела не може да бъде нула!")
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @NotBlank(message = "Линкът за автомобила не може да бъде нула или празно!")
    private String imageUrl;

    @NotNull(message = "Линкът за изображението не може да бъде нула!")
    @Min(value = 1930, message = "Годината на производство трябва да бъде минимум 1930!")
    private Integer startYear;

    @Min(value = 1930, message = "Последната година на производство трябва да бъде минимум 1930!")
    private Integer endYear;

    @NotBlank(message = "Марката не може да бъде нула или празен!")
    private String brandName;
}
