package inventory.controller;


import inventory.controller.dto.*;
import inventory.dao.FilmRepository;
import inventory.exceptions.UnknownFilmException;
import inventory.exceptions.UnknownStoreException;
import inventory.service.FilmService;
import inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
private final FilmService filmService;
private final FilmRepository filmRepository;

    @GetMapping("/inventory")
    public Collection<InventoryDto> listInventory(){
        return inventoryService.getAllInventory()
                .stream()
                .map(model -> InventoryDto.builder()
                        .id(model.getInventory_id())
                        .film(model.getFilm())
                        .store(model.getStore())
                        .build())
                .collect(Collectors.toList());
    }
    @GetMapping("/Films")
    public List<FilmDto> listFilms(){
        return filmService.getAllFilms()
                .stream()
                .map(model -> FilmDto.builder()
                        .title(model.getTitle())
                        .rating(model.getRating())
                        .release_date(model.getReleaseYear())
                        .build())

                .collect(Collectors.toList());
    }

    @DeleteMapping("/deleteInventory")
    public void delete(@RequestBody InventoryDeleteDto inventoryDeleteDtoDto){

        String cim = new String(inventoryDeleteDtoDto.getCim());
        try {
            inventoryService.deleteInventory(cim);
        } catch (UnknownFilmException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/deleteInventoryById")
    public void delete(@RequestBody InventoryDeleteByIdDto inventoryDeleteByIdDto){
        int id = inventoryDeleteByIdDto.getId();
        try {
            inventoryService.deleteInventoryById(id);
        } catch (UnknownFilmException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping("/addInventory")
    public void addInventory(@RequestBody InventoryAddDto inventoryAddDtoDto) {
        try {
            String cim = new String(inventoryAddDtoDto.getCim());
            String varos = new String(inventoryAddDtoDto.getVaros());
            String address = new String(inventoryAddDtoDto.getAddress());
            inventoryService.createInventory(cim, varos, address);
        } catch (UnknownFilmException | UnknownStoreException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/howMuchInStore")
    public int HowMuchInStore(@RequestBody InventoryAddDto inventoryAddDtoDto){

        String cim = new String(inventoryAddDtoDto.getCim());
        String varos = new String(inventoryAddDtoDto.getVaros());
        String address = new String(inventoryAddDtoDto.getAddress());
        try {
            return inventoryService.HowMuchInStore(cim,varos,address);
        } catch (UnknownFilmException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (UnknownStoreException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PostMapping("/addFilm")
    public void addFilm(@RequestBody FilmAddDto filmAddDto){

        filmService.createFilm(filmAddDto.getTitle(), filmAddDto.getDescription(),
                filmAddDto.getReleaseYear(), filmAddDto.getLanguageId(), filmAddDto.getOriginalLanguageId(),
                filmAddDto.getRentalDuration(), filmAddDto.getRentalRate(), filmAddDto.getLength(), filmAddDto.getReplacementCost(),
                filmAddDto.getRating(), filmAddDto.getSpecialFeatures(), new Timestamp((new Date()).getTime()));

    }


}
