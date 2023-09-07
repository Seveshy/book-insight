package com.project.projectbook.dto;

import com.project.projectbook.entities.Book;

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

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInsight() {
        return this.insight;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

}
