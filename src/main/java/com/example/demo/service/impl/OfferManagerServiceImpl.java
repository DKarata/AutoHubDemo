package com.example.demo.service.impl;


import java.util.List;

import com.example.demo.model.dto.*;
import com.example.demo.repository.RentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.OfferEntity;
import com.example.demo.service.AppUserService;
import com.example.demo.service.BrandService;
import com.example.demo.service.ModelService;
import com.example.demo.service.OfferManagerService;
import com.example.demo.service.OfferService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferManagerServiceImpl implements OfferManagerService {
    private final BrandService brandService;
    private final OfferService offerService;
    private final ModelService modelService;
    private final RentRepository rentRepository;
    private final AppUserService appUserService;


    @Override
    @Transactional
    public void addOffer(final OfferAddDTO offerAddDTO, String currentUserId) {
        offerService.persistOffer(offerAddDTO.toEntity(modelService.getByName(offerAddDTO.getModel()), appUserService.findById(currentUserId)));
    }


    @Override
    @Transactional
    public List<BrandDTO> getAllBrandsToDTO() {
        return brandService.getAllBrandsToDTO();
    }


    @Override
    @Transactional
    public Page<OfferViewDTO> getAllOffersToDTO(Pageable pageable, OfferFilterDTO filter) {
        return offerService.getAllOffers(pageable, filter);
    }


    @Override
    @Transactional
    public OfferViewDTO getOfferToDTO(String id) {
        return offerService.getOfferToDTO(id);
    }


    @Override
    @Transactional
    public void updateOffer(final OfferUpdateDTO offerUpdateDTO) {
        final OfferEntity toUpdate = offerService.getOffer(offerUpdateDTO.getId());
        offerUpdateDTO.updateEntity(toUpdate, modelService.getByName(offerUpdateDTO.getModel()));
        offerService.updateOffer(toUpdate);
    }

    @Override
    public void createRent(RentAddDTO rentAddDTO, final String userId) {
        rentRepository.saveAndFlush(rentAddDTO.toEntity(offerService.getOffer(rentAddDTO.getOfferId()), appUserService.findById(userId)));
    }

    @Override
    public void delete(String id) {
        offerService.delete(id);
    }

    @Override
    public boolean isOwner(String userId, String offerId) {
        return offerService.isOwner(userId, offerId);
    }
}
