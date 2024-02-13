package com.epam.book.store.service;

import com.epam.book.store.model.Author;
import com.epam.book.store.model.repo.AuthorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthorService {

  private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
  @Autowired
  private AuthorRepository authorRepository;


  public List<Author> getAllAuthors() {
    logger.info("Fetching all authors");
    return authorRepository.findAll();
  }

  public Author getAuthorById(Long id) {
    logger.info("Fetching author by id: {}", id);
    return authorRepository.findById(id).orElse(null);
  }

  public List<Author> searchAuthorsByName(String name) {
    logger.info("Searching authors by name: {}", name);
    return authorRepository.findByNameContainingIgnoreCase(name);
  }

  public Author saveAuthor(Author author) {
    logger.info("Saving author: {}", author);
    return authorRepository.save(author);
  }

  public void deleteAuthor(Long id) {
    logger.info("Deleting author by id: {}", id);
    authorRepository.deleteById(id);
  }
}
