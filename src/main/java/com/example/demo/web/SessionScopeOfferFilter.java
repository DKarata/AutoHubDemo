package com.example.demo.web;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.model.dto.OfferFilterDTO;


@SessionScope
@Component
public class SessionScopeOfferFilter
{
    private OfferFilterDTO filter;


    public OfferFilterDTO getFilter()
    {
        return filter == null ? filter = new OfferFilterDTO() : filter;
    }


    public SessionScopeOfferFilter setFilter(final OfferFilterDTO filter)
    {
        this.filter = filter;
        return this;
    }
}
