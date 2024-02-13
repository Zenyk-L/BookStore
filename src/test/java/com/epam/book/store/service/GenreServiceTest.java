package com.epam.book.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.book.store.model.Genre;
import com.epam.book.store.model.repo.GenreRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenreServiceTest {

  @Mock
  private GenreRepository genreRepository;

  @InjectMocks
  private GenreService genreService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllGenres() {
    // Prepare
    List<Genre> genres = new ArrayList<>();
    genres.add(new Genre(1L, "Fiction"));
    genres.add(new Genre(2L, "Non-fiction"));
    when(genreRepository.findAll()).thenReturn(genres);

    // Execute
    List<Genre> result = genreService.getAllGenres();

    // Verify
    assertEquals(2, result.size());
    verify(genreRepository, times(1)).findAll();
  }

  @Test
  public void testGetGenreById() {
    // Prepare
    Genre genre = new Genre(1L, "Fiction");
    when(genreRepository.findById(1L)).thenReturn(java.util.Optional.of(genre));

    // Execute
    Genre result = genreService.getGenreById(1L);

    // Verify
    assertEquals(genre, result);
    verify(genreRepository, times(1)).findById(1L);
  }

  @Test
  public void testSearchGenresByName() {
    // Prepare
    String name = "Fiction";
    List<Genre> genres = new ArrayList<>();
    genres.add(new Genre(1L, "Fiction"));
    when(genreRepository.findByNameContainingIgnoreCase(name)).thenReturn(genres);

    // Execute
    List<Genre> result = genreService.searchGenresByName(name);

    // Verify
    assertEquals(1, result.size());
    verify(genreRepository, times(1)).findByNameContainingIgnoreCase(name);
  }

  @Test
  public void testSaveGenre() {
    // Prepare
    Genre genre = new Genre(1L, "Fiction");
    when(genreRepository.save(genre)).thenReturn(genre);

    // Execute
    Genre result = genreService.saveGenre(genre);

    // Verify
    assertEquals(genre, result);
    verify(genreRepository, times(1)).save(genre);
  }

  @Test
  public void testDeleteGenre() {
    // Execute
    genreService.deleteGenre(1L);

    // Verify
    verify(genreRepository, times(1)).deleteById(1L);
  }
}
