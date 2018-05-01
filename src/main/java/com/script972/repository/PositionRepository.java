package com.script972.repository;

import com.script972.entity.Position;

public interface PositionRepository {

    Position getPosition(Position position);

    void addPosition(Position position);

}
