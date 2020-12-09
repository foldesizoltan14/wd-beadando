package inventory.dao;

import inventory.dao.entity.FilmEntity;
import inventory.dao.entity.StoreEntity;
import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StoreRepository extends CrudRepository<StoreEntity, Integer> {

    @Query(value = "SELECT * from store where address_id = :address_id ",nativeQuery = true)
    StoreEntity findFirststorebyCity( @Param("address_id") int address_id);

    @Query(value = "SELECT store_id from store where address_id = :address_id ",nativeQuery = true)
    int findStorId( @Param("address_id") int address_id);

}
