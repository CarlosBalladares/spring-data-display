package com.example.FirstSpringApp.controllers;

import com.example.FirstSpringApp.exceptions.AuthorNotFoundException;
import com.example.FirstSpringApp.model.Author;
import com.example.FirstSpringApp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//@RestController
//@RequestMapping("api/authors")

public class AuthorAPIController {

    private AuthorRepository authorRepository;

    public AuthorAPIController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @GetMapping
    public Iterable<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException(id));
    }
}
