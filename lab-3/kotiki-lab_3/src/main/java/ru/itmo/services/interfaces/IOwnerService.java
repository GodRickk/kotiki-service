package ru.itmo.services.interfaces;

import ru.itmo.dto.CatDto;
import ru.itmo.dto.OwnerDto;

import java.util.List;

public interface IOwnerService {
    OwnerDto findById(Integer id);

    void save(OwnerDto ownerDto);

    void delete(Integer id);

    List<OwnerDto> getAllOwners();

    List<CatDto> getCatsByOwnerId(Integer ownerId);
}
