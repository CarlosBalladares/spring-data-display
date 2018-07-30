package com.example.FirstSpringApp.repositories;

import com.example.FirstSpringApp.model.Author;
import com.example.FirstSpringApp.model.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "publishers", path = "/publishers")
public interface PublisherRepositoryRestAPI extends PagingAndSortingRepository<Publisher, Long> {
}
