package inventory.service;

import inventory.dao.entity.FilmEntity;
import inventory.model.Film;

import java.util.Collection;

public interface FilmService {
    Collection<Film> getAllFilms();
    void createFilm(
                    String title,
                    String description,
                    String releaseYear,
                    long languageId,
                    Integer originalLanguageId,
                    long rentalDuration,
                    double rentalRate,
                    long length,
                    double replacementCost,
                    String rating,
                    String specialFeatures,
                    java.sql.Timestamp lastUpdate);
}

