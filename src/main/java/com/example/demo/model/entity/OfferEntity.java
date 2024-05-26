package com.example.demo.model.entity;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.model.dto.OfferDTO;
import com.example.demo.model.dto.OfferViewDTO;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "offer")
@Getter
@Setter
public class OfferEntity extends BaseEntity<OfferDTO>
{
    @Column
    private BigDecimal price;
    @Column
    private String description;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity user;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @Column(nullable = false)
    private LocalDate manufactured;
    @Column(nullable = false)
    private Integer mileage;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    @Column(nullable = false, length = 10000)
    private String imageUrl;


    @Override
    public OfferDTO toDTO()
    {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setDescription(this.description);
        offerDTO.setUser(this.user.toDTO());
        offerDTO.setModel(this.model.toDTO());
        offerDTO.setPrice(this.price);
        return offerDTO;
    }


    public OfferViewDTO toOfferViewDTO()
    {
        final OfferViewDTO offerViewDTO = new OfferViewDTO();
        offerViewDTO.setId(getId());
        offerViewDTO.setModel(this.model.getModelName());
        offerViewDTO.setBrand(this.model.getBrand().getBrandName());
        offerViewDTO.setEngine(this.engine);
        offerViewDTO.setTransmission(this.transmission);
        offerViewDTO.setYear(this.manufactured);
        offerViewDTO.setMileage(this.mileage);
        offerViewDTO.setPrice(this.price);
        offerViewDTO.setSellerFullName(user.getFirstName() + " " + user.getLastName());
        offerViewDTO.setImageUrl(this.imageUrl);
        offerViewDTO.setDescription(this.description);
        offerViewDTO.setSellerId(user.getId());
        return offerViewDTO;
    }
}
