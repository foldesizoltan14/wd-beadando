package inventory.dao;

import inventory.dao.entity.FilmEntity;
import inventory.model.Film;
import inventory.model.Inventory;

import java.util.Collection;

public interface FilmDao {
    Collection<Film> readAll();
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
