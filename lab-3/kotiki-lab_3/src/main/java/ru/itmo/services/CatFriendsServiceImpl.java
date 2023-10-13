package ru.itmo.services;

/*import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.repository.*;*/
//import ru.itmo.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.dto.CatDto;
import ru.itmo.dto.CatFriendsDto;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.repository.ICatFriendsRepository;
import ru.itmo.repository.ICatRepository;
import ru.itmo.services.interfaces.ICatFriendsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatFriendsServiceImpl implements ICatFriendsService {

    @Autowired
    private ICatFriendsRepository catFriendsRepository;

    @Autowired
    private ICatRepository catRepository;

    @Override
    public CatFriendsDto findById(Integer id) {
        return new CatFriendsDto(catFriendsRepository.findById(id).orElseThrow().getCat_id1(), catFriendsRepository.findById(id).orElseThrow().getCat_id2());
    }

    @Override
    public void save(CatFriendsDto catFriendsDto) {
        CatFriends catFriends = new CatFriends(catFriendsDto.getCatId1(), catFriendsDto.getCatId2());
        if (catFriendsDto.getId() != null) {
            catFriends.setId(catFriendsDto.getId());
        }
        catFriendsRepository.save(catFriends);
    }

    @Override
    public void delete(Integer catFriendsId) {
        catFriendsRepository.deleteById(catFriendsId);
    }

    /*@Override
    public void delete(String catFriendsId) {
        Integer id = Integer.valueOf(catFriendsId);
        catFriendsRepository.deleteById(id);
    }*/

    @Override
    public List<CatFriendsDto> getAll() {
        return catFriendsListToCatFriendsDtoList(catFriendsRepository.findAll());
    }


    @Override
    public List<CatDto> getFriendsByCatId(Integer catId) {
        List<CatFriends> catFriendsList = catFriendsRepository.findAll();
        List<Integer> catFriendsIds = new ArrayList<>();
        for (CatFriends catFriends : catFriendsList) {
            if (catFriends.getCat_id1().equals(catId)) {
                catFriendsIds.add(catFriends.getCat_id2());
            }
            if (catFriends.getCat_id2().equals(catId)) {
                catFriendsIds.add(catFriends.getCat_id1());
            }
        }
        List<Cat> catFriends = catRepository.findAllById(catFriendsIds);
        return catListToCatDtoList(catFriends);
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