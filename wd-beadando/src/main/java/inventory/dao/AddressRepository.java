package inventory.dao;

import inventory.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
    @Query(value = "SELECT * from address where city_id = :city_id  && address like :address",nativeQuery = true)
    AddressEntity findFirstaddressid( @Param("city_id")  int city_id, @Param("address") String address);
}
