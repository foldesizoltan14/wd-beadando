package inventory.dao;

import inventory.dao.entity.AddressEntity;
import inventory.dao.entity.CityEntity;
import inventory.dao.entity.FilmEntity;
import inventory.dao.entity.InventoryEntity;
import inventory.exceptions.UnknownFilmException;
import inventory.exceptions.UnknownStoreException;
import inventory.model.Inventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryDaoImpl implements InventoryDao {



    private final InventoryRepository inventoryRepository;
    private final FilmRepository filmRepository;
    private final StoreRepository storeRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    @Override
    public void createInventory(String cim, String varos,String Address) throws UnknownFilmException, UnknownStoreException
    {
        CityEntity cityEntity = cityRepository.findcityid(varos);
        if(cityEntity==null){throw new UnknownStoreException("Store doesn't exist");}

        int cityid =  cityEntity.getId();
        AddressEntity addressEntity = addressRepository.findFirstaddressid(cityid,Address);
        if(addressEntity==null){throw new UnknownStoreException("Store doesn't exist");}
        int address_id =  addressEntity.getId();


        InventoryEntity inventoryEntity = InventoryEntity.builder().film(filmRepository.findFILMbyTitle(cim))
                .store(storeRepository.findFirststorebyCity(address_id)).lastUpdate(new Timestamp((new Date()).getTime())).build();

        if(inventoryEntity.getFilm()==null){
            throw new UnknownFilmException("Film  doesn't exist");
        }


        inventoryRepository.save(inventoryEntity);

    }
    @Override
    public void deleteInventory(String cim) throws UnknownFilmException {
    FilmEntity filmEntity = filmRepository.findbyTitle(cim);
        if(filmEntity==null){throw new UnknownFilmException("Film doesn't exist");}
    long id =  filmEntity.getFilmId();
    inventoryRepository.deletedbyTitle((int) id);
                    
    }

    @Override
    public void deleteInventoryById(int id) throws UnknownFilmException {
        InventoryEntity inventoryEntity = inventoryRepository.findbyId(id);
        if(inventoryEntity == null){throw new UnknownFilmException("Film doesn't exist");}

        inventoryRepository.deletedbyId(id);
    }


    @Override
    public Collection<Inventory> readAll() {
        return StreamSupport.stream(inventoryRepository.findAll().spliterator(),false)
                .map(entity -> new Inventory(
                        entity.getId(),
                        entity.getFilm().getTitle(),
                        entity.getStore().getAddress_id().getCity().getName())
                ).
                        collect(Collectors.toList());
    }

    @Override
    public int countFilm(String cim, String addres, String varos)  throws UnknownFilmException, UnknownStoreException{
        CityEntity cityEntity = cityRepository.findcityid(varos);
        if(cityEntity==null){throw new UnknownStoreException("Store doesn't exist");}
        int cityid = cityEntity.getId();
        AddressEntity addressEntity = addressRepository.findFirstaddressid(cityid,addres);
        if(addressEntity==null){throw new UnknownStoreException("Store doesn't exist");}

        int address_id =  addressEntity.getId();
        int storeid = storeRepository.findStorId(address_id);
       FilmEntity filmEntity =  filmRepository.findbyTitle(cim);
        if(filmEntity==null){throw new UnknownFilmException("Film doesn't exist");}
        int filmid= (int) filmEntity.getFilmId();
        int result = inventoryRepository.findHowMuchInStore(filmid,storeid);
        if (result == 0){throw new UnknownFilmException("Film is not in store");}
                return result;

    }


}
