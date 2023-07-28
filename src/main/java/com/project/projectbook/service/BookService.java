package com.project.projectbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectbook.dto.BookDto;
import com.project.projectbook.entities.Book;
import com.project.projectbook.exceptions.DatabaseException;
import com.project.projectbook.exceptions.ResourceNotFoundException;
import com.project.projectbook.repositories.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional(readOnly = true)
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new BookDto(book);
    }

    @Transactional(readOnly = true)
    public List<BookDto> findAll() {
        List<Book> bookDtos = bookRepository.findAll();
        return bookDtos.stream().map(book -> new BookDto(book)).toList();
    }

    @Transactional
    public BookDto insert(BookDto bookDto) {
        Book book = new Book();

        book.setTitleBook(bookDto.getTitleBook());
        book.setAuthor(bookDto.getAuthor());
        book.setInsight(bookDto.getInsight());

        book = bookRepository.save(book);
        return new BookDto(book);
    }

    @Transactional
    public BookDto updated(Long id, BookDto bookDto) {
        try {
            Book book = bookRepository.getReferenceById(id);
            book.setTitleBook(bookDto.getTitleBook());
            book.setAuthor(bookDto.getAuthor());
            book.setInsight(bookDto.getInsight());
            book = bookRepository.save(book);
            return new BookDto(book);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            bookRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

}
