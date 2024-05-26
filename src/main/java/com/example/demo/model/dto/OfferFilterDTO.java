package com.example.demo.model.dto;


import java.time.LocalDate;

import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;


public class OfferFilterDTO
{
    private String model;
    private LocalDate year;
    private EngineEnum engine;
    private TransmissionEnum transmission;


    public String getModel()
    {
        if (model == null || model.isBlank())
        {
            return null;
        }
        return model;
    }


    public OfferFilterDTO setModel(final String model)
    {
        this.model = model;
        return this;
    }


    public LocalDate getYear()
    {
        return year;
    }


    public OfferFilterDTO setYear(final LocalDate year)
    {
        this.year = year;
        return this;
    }


    public EngineEnum getEngine()
    {
        return engine;
    }


    public OfferFilterDTO setEngine(final EngineEnum engine)
    {
        this.engine = engine;
        return this;
    }


    public TransmissionEnum getTransmission()
    {
        return transmission;
    }


    public OfferFilterDTO setTransmission(final TransmissionEnum transmission)
    {
        this.transmission = transmission;
        return this;
    }
}
