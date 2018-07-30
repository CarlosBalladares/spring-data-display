package com.example.FirstSpringApp.bootstrap;

import com.example.FirstSpringApp.model.Author;
import com.example.FirstSpringApp.model.Book;
import com.example.FirstSpringApp.model.Publisher;
import com.example.FirstSpringApp.repositories.AuthorRepository;
import com.example.FirstSpringApp.repositories.BookRepository;
import com.example.FirstSpringApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by carlosballadares on 2018-07-27.
 */

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository    authorRepository;
    private BookRepository      bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "SomeAddress");
        Book ddd    = new Book("ddd", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(harperCollins);

        publisherRepository.save(harperCollins);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Publisher wrox =  new Publisher("Wrox", "Wherever wrox may be");
        Book noEJB    = new Book("J2EE development without EJB", "23444");

        rod.getBooks().add(ddd);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(wrox);

        publisherRepository.save(wrox);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }
}
