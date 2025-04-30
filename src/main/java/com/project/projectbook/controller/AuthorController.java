package com.project.projectbook.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.projectbook.dto.AuthorDto;
import com.project.projectbook.dto.BookDto;
import com.project.projectbook.service.AuthorService;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDto> findAll() {
        return authorService.findAll();
    }

    @PostMapping
    public ResponseEntity<AuthorDto> insert(@RequestBody AuthorDto authorDto) {
        authorDto = authorService.insert(authorDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(authorDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(authorDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDto> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
