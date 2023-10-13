package ru.itmo.services.interfaces;

import ru.itmo.dto.CatDto;
import ru.itmo.dto.CatFriendsDto;
import ru.itmo.enums.Color;

import java.util.List;
public interface IUserService {

    List<CatDto> getAllCats();

    List<CatDto> getCatsWithCatColor(Color color);

    void saveCatFriendsPair(CatFriendsDto catFriends);

    List<CatDto> getFriendsByCatId(Integer catId);

    void deleteCatFriendsPair(Integer catFriendsId);

}
