package ru.itmo.services.interfaces;

import ru.itmo.dto.UserDto;

import java.util.List;

public interface IUserStorageService {

        void saveUser(UserDto userDto);

        void deleteUser(Integer userId);

        List<UserDto> getAllUsers();

        void setOwnerToUser(Integer userId, Integer ownerId);
}
