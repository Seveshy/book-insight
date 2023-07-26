package com.project.projectbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.projectbook.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
