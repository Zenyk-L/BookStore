package com.epam.book.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.book.store.model.Author;
import com.epam.book.store.model.repo.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorServiceTest {

  @Mock
  private AuthorRepository authorRepository;

  @InjectMocks
  private AuthorService authorService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllAuthors() {
    List<Author> authors = new ArrayList<>();
    // Add sample authors to the list
    authors.add(new Author(1L, "John Doe"));
    authors.add(new Author(2L, "Jane Smith"));

    when(authorRepository.findAll()).thenReturn(authors);

    List<Author> result = authorService.getAllAuthors();

    assertEquals(authors.size(), result.size());
    verify(authorRepository, times(1)).findAll();
  }

  @Test
  public void testGetAuthorById() {
    Author author = new Author(1L, "John Doe");

    when(authorRepository.findById(1L)).thenReturn(java.util.Optional.of(author));

    Author result = authorService.getAuthorById(1L);

    assertEquals(author.getId(), result.getId());
    assertEquals(author.getName(), result.getName());
    verify(authorRepository, times(1)).findById(1L);
  }

  @Test
  public void testSearchAuthorsByName() {
    String name = "John";
    List<Author> authors = new ArrayList<>();
    // Add sample authors to the list
    authors.add(new Author(1L, "John Doe"));

    when(authorRepository.findByNameContainingIgnoreCase(name)).thenReturn(authors);

    List<Author> result = authorService.searchAuthorsByName(name);

    assertEquals(authors.size(), result.size());
    verify(authorRepository, times(1)).findByNameContainingIgnoreCase(name);
  }

  @Test
  public void testSaveAuthor() {
    Author author = new Author(1L, "John Doe");

    when(authorRepository.save(author)).thenReturn(author);

    Author result = authorService.saveAuthor(author);

    assertEquals(author.getId(), result.getId());
    assertEquals(author.getName(), result.getName());
    verify(authorRepository, times(1)).save(author);
  }

  @Test
  public void testDeleteAuthor() {
    Long id = 1L;

    authorService.deleteAuthor(id);

    verify(authorRepository, times(1)).deleteById(id);
  }
}
