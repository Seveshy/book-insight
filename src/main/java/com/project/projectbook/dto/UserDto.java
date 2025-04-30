package com.project.projectbook.dto;

import com.project.projectbook.entities.User;

public class UserDto {
    private Long id;
    private String email;


    public UserDto(User entitieUser) {
        id = entitieUser.getId();
        email = entitieUser.getEmail();
    }


    public UserDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}
