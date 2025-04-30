package com.project.projectbook.dto;

import com.project.projectbook.entities.Book;

public class BookDto {

    private Long id;
    private String titleBook;
    private Long authorId;
    private String insight;

    public BookDto() {
    }

    public BookDto(Book bookEntities) {
        this.id = bookEntities.getId();
        this.titleBook = bookEntities.getTitleBook();
        this.insight = bookEntities.getInsight();
        if (bookEntities.getAuthor() != null) {
            this.authorId = bookEntities.getAuthor().getId();
        }
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getInsight() {
        return this.insight;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleBook() {
        return this.titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

}
