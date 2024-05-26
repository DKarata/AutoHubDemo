package com.example.demo.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RentDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private OfferViewDTO offerDTO;
    private UserDTO user;
}
