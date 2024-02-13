package com.epam.book.store.model.repo;

import com.epam.book.store.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  List<Author> findByNameContainingIgnoreCase(String name);
}
