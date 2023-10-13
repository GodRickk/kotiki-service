package ru.itmo.services.interfaces;

import ru.itmo.dto.CatDto;
import ru.itmo.dto.OwnerDto;
import ru.itmo.entity.Owner;
import ru.itmo.enums.Color;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface ICatService {
    List<CatDto> getAllCats();

    CatDto findById(Integer id);

    void save(CatDto cat);

    void setOwnerById(Integer catId, Integer ownerId);

    void delete(Integer id);

    OwnerDto findOwnerByCatId(Integer id);

    List<CatDto> getCatsWithCatColor(Color color);
}
