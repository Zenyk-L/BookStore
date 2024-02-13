package com.epam.book.store.controller;

import com.epam.book.store.model.Book;
import com.epam.book.store.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = bookService.getBookById(id);
    return ResponseEntity.ok().body(book);
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    Book savedBook = bookService.saveBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
    Book existingBook = bookService.getBookById(id);
    if (existingBook == null) {
      return ResponseEntity.notFound().build();
    }
    book.setId(id);
    Book updatedBook = bookService.saveBook(book);
    return ResponseEntity.ok().body(updatedBook);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/search")
  public List<Book> searchBooks(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) String author,
      @RequestParam(required = false) String genre) {
    if (title != null) {
      return bookService.searchBooksByTitle(title);
    } else if (author != null) {
      return bookService.searchBooksByAuthor(author);
    } else if (genre != null) {
      return bookService.searchBooksByGenre(genre);
    } else {
      return bookService.getAllBooks();
    }
  }
}
