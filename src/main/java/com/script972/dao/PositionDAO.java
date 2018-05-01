package com.script972.dao;

import com.script972.entity.CardItem;
import com.script972.entity.Position;
import com.script972.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PositionDAO implements PositionRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Position getPosition(Position position) {
        List<Position> result =  entityManager.createQuery("from Position as po where po.lat =:paraLat AND po.lng=:paraLng")
                .setParameter("paraLat", position.getLat())
                .setParameter("paraLng", position.getLng()).getResultList();
        if(result.size()==0)
            return null;
        return result.get(0);


    }

    @Override
    public void addPosition(Position position) {
        this.entityManager.persist(position);

    }
}
