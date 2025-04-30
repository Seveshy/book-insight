package com.project.projectbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.projectbook.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
