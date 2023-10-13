package ru.itmo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.dto.CatDto;
import ru.itmo.dto.CatFriendsDto;
import ru.itmo.dto.OwnerDto;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.entity.Owner;
import ru.itmo.enums.Color;
import ru.itmo.repository.ICatRepository;
import ru.itmo.repository.IOwnerRepository;
import ru.itmo.services.interfaces.ICatService;


import java.util.ArrayList;
import java.util.List;

@Service
public class CatServiceImpl implements ICatService {
    @Autowired
    private ICatRepository iCatRepository;

    @Autowired
    private IOwnerRepository iOwnerRepository;

    @Override
    public CatDto findById(Integer id) {
        Cat cat = iCatRepository.findById(id).orElseThrow();
        return new CatDto(cat.getName(), cat.getBirthDate(), cat.getBreed(), cat.getColor());
    }

    @Override
    public void save(CatDto catDto) {
        Cat cat = new Cat(catDto.getName(), catDto.getBirthDate(), catDto.getBreed(), catDto.getColor());
        if (catDto.getOwner() != null) {
            cat.setOwner(catDto.getOwner());
        }
        if (catDto.getId() != null) {
            cat.setId(catDto.getId());
        }
        iCatRepository.save(cat);
    }

    @Override
    public void setOwnerById(Integer catId, Integer ownerId) {
        Cat cat = iCatRepository.findById(catId).orElseThrow();
        Owner owner = iOwnerRepository.findById(ownerId).orElseThrow();
        cat.setOwner(owner);
        iCatRepository.save(cat);
    }

    @Override
    public void delete(Integer id) {
        iCatRepository.deleteById(id);
    }

    @Override
    public OwnerDto findOwnerByCatId(Integer id) {
        return new OwnerDto(iCatRepository.findById(id).orElseThrow().getOwner().getName(), iCatRepository.findById(id).orElseThrow().getOwner().getBirthDate());
    }

    @Override
    public List<CatDto> getCatsWithCatColor(Color color) {
        List<Cat> allCats = iCatRepository.findAll();
        List<CatDto> colorCats = new ArrayList<>();
        for (Cat cat : allCats) {
            if (cat.getColor().equals(color)) {
                CatDto catDto = new CatDto(cat.getName(), cat.getBirthDate(), cat.getBreed(), cat.getColor());
                colorCats.add(catDto);
            }
        }
        return colorCats;
    }

    @Override
    public List<CatDto> getAllCats(){
        return catListToCatDtoList(iCatRepository.findAll());
    }

    private List<CatFriendsDto> catFriendsListToCatFriendsDtoList(List<CatFriends> catFriendsPairs) {
        ArrayList<CatFriendsDto> catFriendsList = new ArrayList<CatFriendsDto>();
        for (CatFriends catFriends : catFriendsPairs) {
            CatFriendsDto catFriendsPairDto = new CatFriendsDto(catFriends.getCat_id1(), catFriends.getCat_id2());
            catFriendsList.add(catFriendsPairDto);
        }
        return catFriendsList;
    }

    private List<CatDto> catListToCatDtoList(List<Cat> catsList) {
        ArrayList<CatDto> catDtoList = new ArrayList<CatDto>();
        for (Cat cat : catsList) {
            CatDto catDto = new CatDto(cat.getName(), cat.getBirthDate(), cat.getBreed(), cat.getColor());
            catDtoList.add(catDto);
        }

        return catDtoList;
    }
}
