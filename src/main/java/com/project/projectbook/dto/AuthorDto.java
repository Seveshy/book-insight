package com.project.projectbook.dto;

import com.project.projectbook.entities.Author;

public class AuthorDto {

    private Long id;
    private String author;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String author) {
        this.id = id;
        this.author = author;
    }

    public AuthorDto(Author authorEntities) {
        id = authorEntities.getId();
        author = authorEntities.getName();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
