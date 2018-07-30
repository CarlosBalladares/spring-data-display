package com.example.FirstSpringApp.repositories;

import com.example.FirstSpringApp.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authors", path = "/authors")
public interface AuthorRepositoryRestAPI extends PagingAndSortingRepository<Author, Long> {

}

