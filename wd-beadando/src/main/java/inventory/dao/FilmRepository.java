package inventory.dao;

import inventory.dao.entity.FilmEntity;
import inventory.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {
    @Query(value = "SELECT * from film where title = :cim ",nativeQuery = true)
    FilmEntity findbyTitle( @Param ("cim") String cim);

    @Query(value = "SELECT * from film where title = :cim ",nativeQuery = true)
    FilmEntity findFILMbyTitle( @Param ("cim") String cim);
}
