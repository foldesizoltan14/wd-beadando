package inventory.service;

import inventory.dao.FilmDao;
import inventory.dao.entity.FilmEntity;
import inventory.model.Film;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmDao filmDao;


    @Override
    public Collection<Film> getAllFilms() {
    return filmDao.readAll();
    }
@Override
    public  void createFilm(
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
                            java.sql.Timestamp lastUpdate){
        filmDao.createFilm(title,description,releaseYear,languageId,originalLanguageId,rentalDuration,rentalRate,length,replacementCost,rating,specialFeatures,lastUpdate);
}
}


