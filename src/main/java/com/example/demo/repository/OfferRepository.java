package com.example.demo.repository;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.OfferEntity;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.TransmissionEnum;


@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, String>
{
    @Query("SELECT o FROM OfferEntity o "
           + "WHERE "
           + "(:modelName IS NULL OR o.model.modelName = :modelName) "
           + "AND "
           + "(:year IS NULL OR o.manufactured = :year) "
           + "AND "
           + "(:engine IS NULL OR o.engine = :engine) "
           + "AND "
           + "(:transmission IS NULL OR o.transmission = :transmission)")
    Page<OfferEntity> findAllFiltered(final Pageable pageable,
                                      final String modelName,
                                      final LocalDate year,
                                      final EngineEnum engine,
                                      final TransmissionEnum transmission);

    boolean existsByIdAndUserId(String offerId, String userId);
}
