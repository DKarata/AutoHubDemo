package com.example.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.OfferFilterDTO;
import com.example.demo.model.dto.OfferViewDTO;
import com.example.demo.model.entity.OfferEntity;


public interface OfferService
{
    void persistOffer(final OfferEntity offerEntity);


    Page<OfferViewDTO> getAllOffers(final Pageable pageable, OfferFilterDTO filter);


    OfferEntity getOffer(final String id);


    OfferViewDTO getOfferToDTO(final String id);


    void updateOffer(final OfferEntity toUpdate);


    void delete(String id);

    boolean isOwner(String userId, String offerId);
}
