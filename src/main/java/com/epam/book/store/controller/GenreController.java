package com.epam.book.store.controller;

import com.epam.book.store.model.Genre;
import com.epam.book.store.service.GenreService;
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
@RequestMapping("/api/genres")
public class GenreController {

  @Autowired
  private GenreService genreService;

  @GetMapping
  public List<Genre> getAllGenres() {
    return genreService.getAllGenres();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
    Genre genre = genreService.getGenreById(id);
    return ResponseEntity.ok().body(genre);
  }

  @PostMapping
  public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
    Genre savedGenre = genreService.saveGenre(genre);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
    genreService.deleteGenre(id);
    return ResponseEntity.noContent().build();
  }
}
