package com.example.FirstSpringApp.repositories;

import com.example.FirstSpringApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by carlosballadares on 2018-07-27.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
