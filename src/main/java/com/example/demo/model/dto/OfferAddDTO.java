package com.example.demo.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import com.example.demo.model.entity.ModelEntity;
import com.example.demo.model.entity.OfferEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OfferAddDTO
{

    @NotBlank(message = "Моля изберете модел!")
    private String model;

    @NotNull(message = "Моля въведете цена!")
    @Positive(message = "Цената трябва да е по-голяма от 0!")
    private BigDecimal price;

    @NotNull(message = "Моля изберете тип двигател!")
    private EngineEnum engine;

    @NotNull(message = "Моля изберете тип скоростна кутия!")
    private TransmissionEnum transmission;

    @NotNull(message = "Моля изберете година на производство!")
    @PastOrPresent(message = "Годината на производство може да бъде предишна или сегашна!")
    private LocalDate year;

    @NotNull(message = "Моля напишете на колко километра е автомобила!")
    @PositiveOrZero(message = "Километрите трябва да повече от 0!")
    private Integer mileage;

    @NotBlank(message = "Моля напишете описание на автомобила!")
    private String description;

    @NotBlank(message = "Моля поставете линк за изображение на автомобила!")
    private String imageUrl;


    public OfferEntity toEntity(final ModelEntity model, final UserEntity user)
    {
        final OfferEntity offerEntity = new OfferEntity();
        offerEntity.setModel(model);
        offerEntity.setPrice(price);
        offerEntity.setEngine(engine);
        offerEntity.setTransmission(transmission);
        offerEntity.setManufactured(year);
        offerEntity.setMileage(mileage);
        offerEntity.setDescription(description);
        offerEntity.setImageUrl(imageUrl);
        offerEntity.setUser(user);
        return offerEntity;
    }
}
