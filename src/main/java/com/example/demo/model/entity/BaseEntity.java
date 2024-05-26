package com.example.demo.model.entity;


import java.util.Objects;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import org.hibernate.annotations.UuidGenerator;

import lombok.Getter;


@Getter
@MappedSuperclass
abstract class BaseEntity<T>
{
    @Id
    @UuidGenerator
    private String id;


    public abstract T toDTO();


    @Override
    public int hashCode()
    {
        return 31;
    }


    @Override
    public boolean equals(final Object obj)
    {
        if (!(obj instanceof BaseEntity))
        {
            return false;
        }

        if (this.id == null && ((BaseEntity)obj).id == null)
        {
            return this == obj;
        }

        return Objects.equals(((BaseEntity)obj).id, this.id);
    }
}
