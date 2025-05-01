package com.project.projectbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.projectbook.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
