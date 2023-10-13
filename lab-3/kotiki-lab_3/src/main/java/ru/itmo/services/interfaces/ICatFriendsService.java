package ru.itmo.services.interfaces;

import ru.itmo.dto.CatDto;
import ru.itmo.dto.CatFriendsDto;

import java.util.List;

public interface ICatFriendsService {

        CatFriendsDto findById(Integer id);

        void save(CatFriendsDto catFriendsdto);

        void delete(Integer catFriendsId);
        //void delete(String catFriendsId);

        List<CatFriendsDto> getAll();

        List<CatDto> getFriendsByCatId(Integer catId);
}
