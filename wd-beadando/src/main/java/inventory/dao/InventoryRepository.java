package inventory.dao;

import inventory.dao.entity.InventoryEntity;
import inventory.dao.entity.StoreEntity;
import inventory.model.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface InventoryRepository extends CrudRepository<InventoryEntity, Integer> {
   @Transactional
    @Modifying
    @Query(value = "DELETE from inventory where film_id = :id",nativeQuery = true)
    int deletedbyTitle( @Param("id") int id);

 @Transactional
 @Modifying
 @Query(value = "DELETE from inventory where inventory_id = :id",nativeQuery = true)
 int deletedbyId( @Param("id") int id);


    @Query(value = "SELECT count(*) from inventory where film_id = :film_id && store_id = :store_id",nativeQuery = true)
    int findHowMuchInStore(@Param("film_id") int film_id,@Param("store_id") int store_id);

 @Query(value = "SELECT * from inventory where inventory_id = :inventory_id ",nativeQuery = true)
 InventoryEntity findbyId(@Param("inventory_id") int inventory_id);
}
