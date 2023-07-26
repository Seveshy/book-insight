package com.project.projectbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titleBook;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String insight;

    public Book() {
    }

    public Book(Long id, String titleBook, String author, String insight) {
        this.id = id;
        this.titleBook = titleBook;
        this.author = author;
        this.insight = insight;
    }

}
