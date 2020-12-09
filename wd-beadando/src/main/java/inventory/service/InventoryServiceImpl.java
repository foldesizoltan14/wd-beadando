package inventory.service;

import inventory.dao.InventoryDao;
import inventory.exceptions.UnknownFilmException;
import inventory.exceptions.UnknownStoreException;
import inventory.model.Inventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryDao inventoryDao;

    @Override
    public Collection<Inventory> getAllInventory() {
        return inventoryDao.readAll();
    }

    @Override
    public void deleteInventory(String cim)throws UnknownFilmException {
    inventoryDao.deleteInventory(cim);
    }
    @Override
    public void deleteInventoryById(int id)throws UnknownFilmException {
        inventoryDao.deleteInventoryById(id);
    }
    @Override
    public void createInventory(String cim, String varos, String Address) throws UnknownFilmException, UnknownStoreException {
        inventoryDao.createInventory(cim,varos, Address);
    }

    @Override
    public int HowMuchInStore(String cim, String varos, String Address) throws UnknownFilmException, UnknownStoreException {

        return inventoryDao.countFilm(cim,Address,varos);
    }
}
