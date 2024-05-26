package com.example.demo.service;


import java.util.List;

import com.example.demo.model.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OfferManagerService {
    void addOffer(final OfferAddDTO offerAddDTO, final String currentUserId);


    List<BrandDTO> getAllBrandsToDTO();


    Page<OfferViewDTO> getAllOffersToDTO(final Pageable pageable, final OfferFilterDTO filter);


    OfferViewDTO getOfferToDTO(final String id);


    void updateOffer(final OfferUpdateDTO offerUpdateDTO);

    void createRent(RentAddDTO rentAddDTO, final String userId);

    void delete(String id);

    boolean isOwner(String userId, String offerId);
}
