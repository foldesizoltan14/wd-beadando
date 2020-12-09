package inventory.model;

import inventory.dao.entity.FilmEntity;
import inventory.dao.entity.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Inventory {

    private int inventory_id;
    private String film;
    private String store;

}
