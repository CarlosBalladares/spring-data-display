package com.example.FirstSpringApp.repositories;

import com.example.FirstSpringApp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by carlosballadares on 2018-07-27.
 */
public interface BookRepository extends CrudRepository<Book, Long>{
}
