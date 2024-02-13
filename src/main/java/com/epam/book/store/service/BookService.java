package com.epam.book.store.service;

import com.epam.book.store.model.Book;
import com.epam.book.store.model.repo.BookRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {
  private static final Logger logger = LoggerFactory.getLogger(BookService.class);

  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAllBooks() {
    logger.info("Fetching all books");
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    logger.info("Fetching book by id: {}", id);
    return bookRepository.findById(id).orElse(null);
  }

  public List<Book> searchBooksByTitle(String title) {
    logger.info("Searching books by title: {}", title);
    return bookRepository.findByTitleContainingIgnoreCase(title);
  }

  public List<Book> searchBooksByAuthor(String authorName) {
    logger.info("Searching books by author: {}", authorName);
    return bookRepository.findByAuthorNameContainingIgnoreCase(authorName);
  }

  public List<Book> searchBooksByGenre(String genreName) {
    logger.info("Searching books by genre: {}", genreName);
    return bookRepository.findByGenreNameContainingIgnoreCase(genreName);
  }

  public Book saveBook(Book book) {
    logger.info("Saving book: {}", book);
    return bookRepository.save(book);
  }

  public void deleteBook(Long id) {
    logger.info("Deleting book by id: {}", id);
    bookRepository.deleteById(id);
  }
}
