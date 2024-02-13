package com.epam.book.store.controller;

import com.epam.book.store.model.Author;
import com.epam.book.store.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @GetMapping
  public List<Author> getAllAuthors() {
    return authorService.getAllAuthors();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
    Author author = authorService.getAuthorById(id);
    return ResponseEntity.ok().body(author);
  }

  @PostMapping
  public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
    Author savedAuthor = authorService.saveAuthor(author);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    authorService.deleteAuthor(id);
    return ResponseEntity.noContent().build();
  }
}
