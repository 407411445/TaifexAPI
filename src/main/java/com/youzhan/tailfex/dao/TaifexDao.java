package com.youzhan.tailfex.dao;


import com.youzhan.tailfex.model.Taifex;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Repository
public class TaifexDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void insertTaifexDto(Taifex entity) {
        entityManager.persist(entity);
    }

    public Taifex findTaifexDtoByDate(String datetime) {
        return entityManager.find(Taifex.class, datetime);
    }

    public void updateTaifexDto(Taifex entity) {
        entityManager.merge(entity);
    }

    public void deleteTaifexDto(Taifex entity) {
        entityManager.remove(entity);
    }
}
