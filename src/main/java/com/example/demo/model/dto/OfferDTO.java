package com.example.demo.model.dto;


import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OfferDTO
{
    private BigDecimal price;
    private String description;
    private ModelDTO model;
    private UserDTO user;
}
