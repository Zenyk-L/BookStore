package com.epam.book.store.model.repo;

import com.epam.book.store.model.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
  List<Genre> findByNameContainingIgnoreCase(String name);
}
