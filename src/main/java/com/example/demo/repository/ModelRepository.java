package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ModelEntity;


@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, String>
{
    Optional<ModelEntity> findByModelName(final String modelName);
}
