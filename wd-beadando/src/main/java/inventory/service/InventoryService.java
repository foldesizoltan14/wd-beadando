package inventory.service;

import inventory.exceptions.UnknownFilmException;
import inventory.exceptions.UnknownStoreException;
import inventory.model.Inventory;

import java.util.Collection;

public interface InventoryService {
    Collection<Inventory> getAllInventory();
    void deleteInventory(String cim) throws UnknownFilmException;
    void deleteInventoryById(int id) throws UnknownFilmException;
    void createInventory(String cim, String varos, String Address) throws UnknownFilmException, UnknownStoreException;
    int HowMuchInStore(String cim, String varos, String Address) throws UnknownFilmException, UnknownStoreException;
}
