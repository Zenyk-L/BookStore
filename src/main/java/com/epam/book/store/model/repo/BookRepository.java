package com.epam.book.store.model.repo;

import com.epam.book.store.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByTitleContainingIgnoreCase(String title);

  List<Book> findByAuthorNameContainingIgnoreCase(String authorName);

  List<Book> findByGenreNameContainingIgnoreCase(String genreName);
}
