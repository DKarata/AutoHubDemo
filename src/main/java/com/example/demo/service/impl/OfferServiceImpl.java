package com.example.demo.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.OfferFilterDTO;
import com.example.demo.model.dto.OfferViewDTO;
import com.example.demo.model.entity.OfferEntity;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService
{

    private final OfferRepository offerRepository;


    @Override
    @Transactional
    public void persistOffer(OfferEntity offerEntity)
    {
        offerRepository.save(offerEntity);
    }


    @Override
    @Transactional
    public Page<OfferViewDTO> getAllOffers(Pageable pageable, OfferFilterDTO filter)
    {
        return offerRepository.findAllFiltered(pageable, filter.getModel(), filter.getYear(), filter.getEngine(), filter.getTransmission())
                              .map(OfferEntity::toOfferViewDTO);
    }


    @Override
    public OfferEntity getOffer(final String id)
    {
        return offerRepository.findById(id)
                              .orElseThrow();
    }


    @Override
    @Transactional
    public OfferViewDTO getOfferToDTO(String id)
    {
        return getOffer(id).toOfferViewDTO();
    }


    @Override
    @Transactional
    public void updateOffer(final OfferEntity toUpdate)
    {
        offerRepository.saveAndFlush(toUpdate);
    }


    @Override
    public void delete(String id)
    {
        offerRepository.delete(offerRepository.findById(id).orElseThrow());
    }

    @Override
    public boolean isOwner(String userId, String offerId) {
        return offerRepository.existsByIdAndUserId(offerId, userId);
    }

}
