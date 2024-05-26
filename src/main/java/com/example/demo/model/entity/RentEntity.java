package com.example.demo.model.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.model.dto.RentDTO;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "rent")
@Getter
@Setter
public class RentEntity extends BaseEntity<RentDTO> {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @ManyToOne
    private OfferEntity offer;
    @ManyToOne
    private UserEntity user;


    @Override
    public RentDTO toDTO() {
        RentDTO rentDTO = new RentDTO();
        rentDTO.setUser(this.user.toDTO());
        rentDTO.setEndDate(this.endDate);
        rentDTO.setStartDate(this.startDate);
        rentDTO.setOfferDTO(offer.toOfferViewDTO());
        return rentDTO;
    }
}
