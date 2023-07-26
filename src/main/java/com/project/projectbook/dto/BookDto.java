package com.project.projectbook.dto;

import com.project.projectbook.entities.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private Long id;
    private String titleBook;
    private String author;
    private String insight;

    public BookDto() {
    }

    public BookDto(Long id, String titleBook, String author, String insight) {
        this.id = id;
        this.titleBook = titleBook;
        this.author = author;
        this.insight = insight;
    }

    public BookDto(Book bookEntities) {
        id = bookEntities.getId();
        titleBook = bookEntities.getTitleBook();
        author = bookEntities.getAuthor();
        insight = bookEntities.getInsight();
    }

}
