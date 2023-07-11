package com.project.projectbook.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Insights> insights;

    public Book() {
    }

    public Book(String titleBook, String author) {
        this.titleBook = titleBook;
        this.author = author;
    }

}
