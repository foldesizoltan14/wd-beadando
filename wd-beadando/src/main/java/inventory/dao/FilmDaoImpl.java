package inventory.dao;

import inventory.dao.entity.FilmEntity;
import inventory.dao.entity.InventoryEntity;
import inventory.model.Film;
import inventory.model.Inventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {
    private final FilmRepository filmRepository;
    @Override
    public Collection<Film> readAll() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(),false)
                .map(entity -> new Film(
                        entity.getFilmId(),
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.getReleaseYear(),
                        entity.getLanguageId(),
                        entity.getOriginalLanguageId(),
                        entity.getRentalDuration(),
                        entity.getRentalRate(),
                        entity.getLength(),
                        entity.getReplacementCost(),
                        entity.getRating(),
                        entity.getSpecialFeatures(),
                        entity.getLastUpdate()
                )).collect(Collectors.toList());

    }
    @Override
    public void createFilm(String title, String description, String releaseYear, long languageId, Integer originalLanguageId, long rentalDuration, double rentalRate, long length, double replacementCost, String rating, String specialFeatures, java.sql.Timestamp lastUpdate){
            FilmEntity filmEntity;

            filmEntity = FilmEntity.builder().title(title).description(description)
                    .releaseYear(releaseYear).languageId(languageId).originalLanguageId(originalLanguageId)
                    .rentalDuration(rentalDuration).rentalRate(rentalRate).length(length).replacementCost(replacementCost)
                    .rating(rating).specialFeatures(specialFeatures).lastUpdate(lastUpdate).build();
            filmRepository.save(filmEntity);
    }


}
