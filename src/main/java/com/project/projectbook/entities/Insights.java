package com.project.projectbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_insight")
@Getter
@Setter
public class Insights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titleBook;

    @Column(nullable = false)
    private String titileInsight;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Insights() {
    }

    public Insights(Long id, String titleBook, String titileInsight, String name) {
        this.id = id;
        this.titleBook = titleBook;
        this.titileInsight = titileInsight;
        this.name = name;
    }

}
