package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Integer>, JpaSpecificationExecutor<Owner> {

}
