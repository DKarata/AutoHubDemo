package com.example.demo.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OfferViewDTO
{
    private String id;

    private String description;

    private EngineEnum engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    private TransmissionEnum transmission;

    private LocalDate year;

    private String model;

    private String brand;

    private String sellerFullName;
    private String sellerId;


    public String offerSummary()
    {
        return year.getYear() + " " + brand + " " + model;
    }
}
