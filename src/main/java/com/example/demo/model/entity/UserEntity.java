package com.example.demo.model.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.demo.model.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity()
@Table(name = "app_user")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity<UserDTO>
{
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Boolean active;

    @ManyToMany
    @JoinTable(name = "app_user_app_user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRoleEntity> roles;

    @Column
    private String imageUrl;
    @OneToMany(
                    mappedBy = "user",
                    fetch = FetchType.LAZY
    )
    private List<CommentEntity> comment;


    @Override
    public UserDTO toDTO()
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(getId());
        userDTO.setComment(this.comment.stream().map(CommentEntity::toDTO).toList());
        userDTO.setEmail(this.email);
        userDTO.setFirstName(this.firstName);
        userDTO.setLastName(this.lastName);
        userDTO.setImageUrl(this.imageUrl);
        return userDTO;
    }
}
