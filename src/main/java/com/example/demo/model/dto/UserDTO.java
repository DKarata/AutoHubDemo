package com.example.demo.model.dto;


import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private List<CommentDTO> comment;


    public String getDescription()
    {
        return "First Name: " + firstName + " Last Name: " + lastName + " Email: " + email + " ";
    }

}
