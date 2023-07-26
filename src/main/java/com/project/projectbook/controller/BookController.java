package com.project.projectbook.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.projectbook.dto.BookDto;
import com.project.projectbook.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id) {
        BookDto bookDto = bookService.findById(id);
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<BookDto> insert(@RequestBody BookDto bookDto) {
        System.out.println(bookDto);
        bookDto = bookService.insert(bookDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(bookDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> updated(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookDto = bookService.updated(id, bookDto);
        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDto> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
