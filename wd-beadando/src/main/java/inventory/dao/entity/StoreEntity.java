package inventory.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "store", schema = "sakila")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private int id;

    @Column(name="manager_staff_id")
    private int staff_id ;

    @OneToOne
    @JoinColumn(name="address_id")
    private AddressEntity address_id;


   @Column(name = "last_update")
    private Timestamp lastUpdate;

}
