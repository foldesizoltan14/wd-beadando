package inventory.dao;

import inventory.dao.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository  extends CrudRepository<CountryEntity, Integer> {
}
