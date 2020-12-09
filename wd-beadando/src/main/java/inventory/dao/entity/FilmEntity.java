package inventory.dao.entity;


import com.sun.istack.Nullable;
import lombok.*;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Timestamp;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "film", schema = "sakila")
public class FilmEntity {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private long filmId;
    @Column
    private String title;
    @Column
    private String description;
    @Column(name="release_year")
    private String releaseYear;
    @Column(name="language_id")
    private long languageId;
    @Column(name= "original_language_id")
    private Integer originalLanguageId;
    @Column(name="rental_duration")
    private long rentalDuration;
    @Column(name="rental_rate")
    private double rentalRate;
    @Column
    private long length;
    @Column(name="replacement_cost")
    private double replacementCost;

    @Column(name = "rating", columnDefinition = "enum('G','PG','PG-13','R','NC-17')")
    private String rating;
    @Column(name="special_features")
    private String specialFeatures;
    @Column(name="last_update")
    private java.sql.Timestamp lastUpdate;

}
