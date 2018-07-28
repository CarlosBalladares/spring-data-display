package com.example.FirstSpringApp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Author
 */
@Entity
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Author(){}

  public Author(String firstName, String lastName, Set<Book> books) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.books = books;
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return the id
   */
  public Long getId() {
	return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
	this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
	return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
	return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  /**
   * @return the books
   */
  public Set<Book> getBooks() {
	return books;
  }

  /**
   * @param books the books to set
   */
  public void setBooks(Set<Book> books) {
	this.books = books;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    return id != null ? id.equals(author.id) : author.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Author{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", books=" + books +
            '}';
  }
}