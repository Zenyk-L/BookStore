package com.epam.book.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.book.store.model.Book;
import com.epam.book.store.model.repo.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookService bookService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetAllBooks() {
    List<Book> books = new ArrayList<>();
    // Add sample books to the list
    books.add(new Book());
    books.add(new Book());
    when(bookRepository.findAll()).thenReturn(books);

    List<Book> result = bookService.getAllBooks();

    assertEquals(2, result.size());
  }

  @Test
  void testGetBookById() {
    Long id = 1L;
    Book book = new Book();
    book.setId(id);
    when(bookRepository.findById(id)).thenReturn(Optional.of(book));

    Book result = bookService.getBookById(id);

    assertEquals(id, result.getId());
  }

  @Test
  void testSearchBooksByTitle() {
    String title = "Sample Title";
    List<Book> books = new ArrayList<>();
    // Add sample books to the list
    books.add(new Book());
    when(bookRepository.findByTitleContainingIgnoreCase(title)).thenReturn(books);

    List<Book> result = bookService.searchBooksByTitle(title);

    assertEquals(1, result.size());
  }

  @Test
  void testSearchBooksByAuthor() {
    String authorName = "Sample Author";
    List<Book> books = new ArrayList<>();
    // Add sample books to the list
    books.add(new Book());
    when(bookRepository.findByAuthorNameContainingIgnoreCase(authorName)).thenReturn(books);

    List<Book> result = bookService.searchBooksByAuthor(authorName);

    assertEquals(1, result.size());
  }

  @Test
  void testSearchBooksByGenre() {
    String genreName = "Sample Genre";
    List<Book> books = new ArrayList<>();
    // Add sample books to the list
    books.add(new Book());
    when(bookRepository.findByGenreNameContainingIgnoreCase(genreName)).thenReturn(books);

    List<Book> result = bookService.searchBooksByGenre(genreName);

    assertEquals(1, result.size());
  }

  @Test
  void testSaveBook() {
    Book book = new Book();
    when(bookRepository.save(book)).thenReturn(book);

    Book result = bookService.saveBook(book);

    assertEquals(book, result);
  }

  @Test
  void testDeleteBook() {
    Long id = 1L;

    bookService.deleteBook(id);

    verify(bookRepository, times(1)).deleteById(id);
  }
}
