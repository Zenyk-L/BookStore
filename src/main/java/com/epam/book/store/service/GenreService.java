package com.epam.book.store.service;

import com.epam.book.store.model.Genre;
import com.epam.book.store.model.repo.GenreRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GenreService {

  private static final Logger logger = LoggerFactory.getLogger(GenreService.class);

  @Autowired
  private GenreRepository genreRepository;

  public List<Genre> getAllGenres() {
    logger.info("Fetching all genres");
    return genreRepository.findAll();
  }

  public Genre getGenreById(Long id) {
    logger.info("Fetching genre by id: {}", id);
    return genreRepository.findById(id).orElse(null);
  }

  public List<Genre> searchGenresByName(String name) {
    logger.info("Searching genres by name: {}", name);
    return genreRepository.findByNameContainingIgnoreCase(name);
  }

  public Genre saveGenre(Genre genre) {
    logger.info("Saving genre: {}", genre);
    return genreRepository.save(genre);
  }

  public void deleteGenre(Long id) {
    logger.info("Deleting genre by id: {}", id);
    genreRepository.deleteById(id);
  }
}
