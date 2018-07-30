package com.example.FirstSpringApp.repositories;

import com.example.FirstSpringApp.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "/books")
public interface BookRepositoryRestAPI extends PagingAndSortingRepository<Book, Long> {
}
