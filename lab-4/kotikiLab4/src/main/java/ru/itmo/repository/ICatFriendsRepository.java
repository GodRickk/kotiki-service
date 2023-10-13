package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;

import java.util.List;

@Repository
public interface ICatFriendsRepository extends JpaRepository<CatFriends, Integer> {
    List<CatFriends> findByCatId1OrCatId2(Integer Cat1Id, Integer Cat2Id);
}
