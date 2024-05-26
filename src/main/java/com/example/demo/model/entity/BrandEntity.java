package com.example.demo.model.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.demo.model.dto.BrandDTO;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity extends BaseEntity<BrandDTO>
{
    //ime
    @Column(nullable = false)
    private String brandName;
    @OneToMany(
                    mappedBy = "brand",
                    fetch = FetchType.LAZY
    )
    private List<ModelEntity> models;


    @Override
    public BrandDTO toDTO()
    {
        final BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(this.brandName);
        brandDTO.setModels(this.models.stream().map(ModelEntity::toDTO).toList());
        return brandDTO;
    }
}
