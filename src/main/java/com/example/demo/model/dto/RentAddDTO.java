package com.example.demo.model.dto;


import com.example.demo.model.entity.ModelEntity;
import com.example.demo.model.entity.OfferEntity;
import com.example.demo.model.entity.RentEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class RentAddDTO {
    @NotBlank
    private String offerId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;


    public RentEntity toEntity(final OfferEntity model, final UserEntity user) {
        RentEntity rentEntity = new RentEntity();
        rentEntity.setUser(user);
        rentEntity.setOffer(model);
        rentEntity.setStartDate(startDate);
        rentEntity.setEndDate(endDate);
        return rentEntity;
    }
}
