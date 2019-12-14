package com.bulldozer.domain.bulldozer;

public interface IBulldozerController {
    void turnLeft();
    void turnRight();
    void move(int distance);

    int getUsedFuelAmount();

    int getDamagedPaintAmount();

    int getCommandsCount();
}
