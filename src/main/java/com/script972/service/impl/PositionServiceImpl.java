package com.script972.service.impl;

import com.script972.entity.Position;
import com.script972.repository.PositionRepository;
import com.script972.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionRepository repository;

    @Override
    public Position getPosition(Position position) {
        return this.repository.getPosition(position);
    }

    @Override
    public void addPosition(Position position) {
        this.repository.addPosition(position);
    }
}
