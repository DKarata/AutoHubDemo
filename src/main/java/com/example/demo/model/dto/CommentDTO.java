package com.example.demo.model.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentDTO
{
    private String text;
    private UserDTO user;
}
