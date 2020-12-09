package inventory.dao;

import inventory.exceptions.UnknownFilmException;
import inventory.exceptions.UnknownStoreException;
import inventory.model.Inventory;

import java.util.Collection;

public interface InventoryDao {
    void createInventory(String cim, String varos, String Address) throws UnknownFilmException, UnknownStoreException;
    void deleteInventory(String cim) throws UnknownFilmException;
    void deleteInventoryById(int id) throws UnknownFilmException;
    Collection<Inventory> readAll();
    int countFilm(String cim,String addres, String varos) throws UnknownFilmException, UnknownStoreException;
}
