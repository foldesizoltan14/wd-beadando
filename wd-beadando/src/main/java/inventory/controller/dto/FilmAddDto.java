package inventory.controller.dto;

import inventory.dao.entity.FilmEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FilmAddDto {

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

}
