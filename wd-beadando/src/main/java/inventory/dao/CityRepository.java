package inventory.dao;

import inventory.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {

    @Query(value = "SELECT * from city where city = :cim ",nativeQuery = true)
    CityEntity findcityid( @Param("cim") String cim);
}
