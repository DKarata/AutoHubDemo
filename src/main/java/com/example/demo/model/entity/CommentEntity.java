package com.example.demo.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.model.dto.CommentDTO;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "comment")
@Getter
@Setter
public class CommentEntity extends BaseEntity<CommentDTO>
{
    @Column
    private String text;
    @ManyToOne(
                    targetEntity = UserEntity.class,
                    fetch = FetchType.LAZY
    )
    private UserEntity user;


    @Override
    public CommentDTO toDTO()
    {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText(this.text);
        commentDTO.setUser(this.user.toDTO());
        return commentDTO;
    }
}
