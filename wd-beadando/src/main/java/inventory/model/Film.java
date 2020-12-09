package inventory.model;

import inventory.dao.entity.FilmEntity;
import lombok.*;

import javax.persistence.Column;
@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
@Builder
public class Film {
    private long filmId;
    private String title;
    private String description;
    private String releaseYear;
    private long languageId;
    private Integer originalLanguageId;
    private long rentalDuration;
    private double rentalRate;
    private long length;
    private double replacementCost;
    private String rating;
    private String specialFeatures;
    private java.sql.Timestamp lastUpdate;
}
