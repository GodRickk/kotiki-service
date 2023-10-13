package ru.itmo.repository;

import org.hibernate.Cache;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.entity.Owner;
import ru.itmo.enums.Color;

import java.util.List;

@Repository
public interface ICatRepository extends JpaRepository<Cat, Integer> {

    List<Cat> findByColor(Color color);
    List<Cat> findByColorAndOwner(Color color, Owner owner);
    List<Cat> findByOwner(Owner owner);
}

