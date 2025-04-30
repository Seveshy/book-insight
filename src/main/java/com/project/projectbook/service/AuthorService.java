package com.project.projectbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectbook.dto.AuthorDto;
import com.project.projectbook.entities.Author;
import com.project.projectbook.exceptions.DatabaseException;
import com.project.projectbook.exceptions.ResourceNotFoundException;
import com.project.projectbook.repositories.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<AuthorDto> findAll() {
        List<Author> bookDtos = authorRepository.findAll();
        return bookDtos.stream().map(author -> new AuthorDto(author)).toList();
    }

    @Transactional
    public AuthorDto insert(AuthorDto authorDto) {
        Author author = new Author();

        author.setName(authorDto.getAuthor());

        author = authorRepository.save(author);
        return new AuthorDto(author);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            authorRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

}
