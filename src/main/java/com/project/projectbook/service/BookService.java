package com.project.projectbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectbook.dto.BookDto;
import com.project.projectbook.entities.Book;
import com.project.projectbook.exceptions.ResourceNotFoundException;
import com.project.projectbook.repositories.BookRepository;

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
        Book book = bookRepository.getReferenceById(id);

        book.setTitleBook(bookDto.getTitleBook());
        book.setAuthor(bookDto.getAuthor());
        book.setInsight(bookDto.getInsight());

        book = bookRepository.save(book);
        return new BookDto(book);
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
