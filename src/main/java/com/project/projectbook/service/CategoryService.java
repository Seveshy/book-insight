package com.project.projectbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectbook.dto.BookDto;
import com.project.projectbook.dto.CategoryDto;
import com.project.projectbook.entities.Author;
import com.project.projectbook.entities.Book;
import com.project.projectbook.entities.Category;
import com.project.projectbook.exceptions.DatabaseException;
import com.project.projectbook.exceptions.ResourceNotFoundException;
import com.project.projectbook.repositories.AuthorRepository;
import com.project.projectbook.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Category book = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new CategoryDto(book);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> categoriesDto = categoryRepository.findAll();
        return categoriesDto.stream().map(category -> new CategoryDto(category)).toList();
    }

    @Transactional
    public CategoryDto insert(CategoryDto categoryDto) {
        Category category = new Category();

        category.setCategory(categoryDto.getCategory());

        category = categoryRepository.save(category);
        return new CategoryDto(category);
    }

    @Transactional
    public CategoryDto updated(Long id, CategoryDto categoryDto) {
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setCategory(categoryDto.getCategory());

            category = categoryRepository.save(category);
            return new CategoryDto(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

}
