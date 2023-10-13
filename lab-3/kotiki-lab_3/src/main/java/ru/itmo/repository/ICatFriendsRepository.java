package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;

@Repository
public interface ICatFriendsRepository extends JpaRepository<CatFriends, Integer>, JpaSpecificationExecutor<CatFriends> {

}
