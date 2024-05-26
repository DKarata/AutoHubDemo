package com.example.demo.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.model.dto.ModelDTO;
import com.example.demo.model.enums.CategoryEnum;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "model")
@Getter
@Setter
public class ModelEntity extends BaseEntity<ModelDTO>
{
    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @Column(nullable = false, length = 1000)
    private String imageUrl;
    @Column(nullable = false)
    private Integer startYear;
    @Column
    private Integer endYear;
    @ManyToOne(
                    targetEntity = BrandEntity.class,
                    fetch = FetchType.LAZY
    )
    private BrandEntity brand;


    @Override
    public ModelDTO toDTO()
    {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setName(this.modelName);
        modelDTO.setBrandName(this.brand.getBrandName());
        modelDTO.setImageUrl(this.imageUrl);
        modelDTO.setStartYear(this.startYear);
        modelDTO.setEndYear(this.endYear);
        modelDTO.setCategory(this.category);
        return modelDTO;
    }
}
